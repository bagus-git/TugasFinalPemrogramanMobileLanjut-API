<?php namespace App\Controllers;
 
use CodeIgniter\RESTful\ResourceController;
use CodeIgniter\API\ResponseTrait;
use App\Models\CelengankuModel;
 
class Celenganku extends ResourceController
{
    use ResponseTrait;
    // get all celenganku
    public function index()
    {
        $model = new CelengankuModel();
        $data = $model->findAll();
        return $this->respond($data, 200);
    }
 
    // get single celengan
    public function show($id = null)
    {
        $model = new CelengankuModel();
        $data = $model->getWhere(['id' => $id])->getResult();
        if($data){
            return $this->respond($data);
        }else{
            return $this->failNotFound('No Data Found with id '.$id);
        }
    }
 
    // create a celenganku
    public function create()
    {
        $model = new CelengankuModel();
        $data = [
            'email' => $this->request->getPost('email'),
            'password' => $this->request->getPost('password'),
            're_entry_password' => $this->request->getPost('re_entry_password')
        ];
        // $data = json_decode(file_get_contents("php://input"));
        //$data = $this->request->getPost();
        $model->insert($data);
        $response = [
            'status'   => 201,
            'error'    => null,
            'messages' => [
                'success' => 'Data Saved'
            ]
        ];
         
        return $this->respondCreated($data, 201);
    }
 
    // update product
    public function update($id = null)
    {
        $model = new CelengankuModel();
        $json = $this->request->getJSON();
        if($json){
            $data = [
                'email' => $json->email,
                'password' => $json->password,
                're_entry_password' => $json->re_entry_password
            ];
        }else{
            $input = $this->request->getRawInput();
            $data = [
                'email' => $input['email'],
                'password' => $input['password'],
                're_entry_password' => $input['re_entry_password']
            ];
        }
        // Insert to Database
        $model->update($id, $data);
        $response = [
            'status'   => 200,
            'error'    => null,
            'messages' => [
                'success' => 'Data Updated'
            ]
        ];
        return $this->respond($response);
    }
 
    // delete product
    public function delete($id = null)
    {
        $model = new CelengankuModel();
        $data = $model->find($id);
        if($data){
            $model->delete($id);
            $response = [
                'status'   => 200,
                'error'    => null,
                'messages' => [
                    'success' => 'Data Deleted'
                ]
            ];
             
            return $this->respondDeleted($response);
        }else{
            return $this->failNotFound('No Data Found with id '.$id);
        }
         
    }
 
}