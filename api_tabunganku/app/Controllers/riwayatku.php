<?php namespace App\Controllers;
 
use CodeIgniter\RESTful\ResourceController;
use CodeIgniter\API\ResponseTrait;
use App\Models\RiwayatkuModel;
 
class Riwayatku extends ResourceController
{
    use ResponseTrait;
    // get all product
    public function index()
    {
        $model = new RiwayatkuModel();
        $data = $model->findAll();
        return $this->respond($data, 200);
    }
 
    // get single product
    public function show($id = null)
    {
        $model = new RiwayatkuModel();
        $data = $model->getWhere(['id' => $id])->getResult();
        if($data){
            return $this->respond($data);
        }else{
            return $this->failNotFound('No Data Found with id '.$id);
        }
    }
 
    // create a product
    public function create()
    {
        $model = new RiwayatkuModel();
        $data = [
            'nama_pengeluaran' => $this->request->getPost('nama_pengeluaran'),
            'jumlah_pengeluaran' => $this->request->getPost('jumlah_pengeluaran'),
            'tanggal_bulan_tahun' => $this->request->getPost('tanggal_bulan_tahun'),
            'catatan_pengeluaran' => $this->request->getPost('catatan_pengeluaran')
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
        $model = new RiwayatkuModel();
        $json = $this->request->getJSON();
        if($json){
            $data = [
                'nama_pengeluaran' => $json->nama_pengeluaran,
                'jumlah_pengeluaran' => $json->jumlah_pengeluaran,
                'tanggal_bulan_tahun' => $json->tanggal_bulan_tahun,
                'catatan_pengeluaran' => $json->catatan_pengeluaran
            ];
        }else{
            $input = $this->request->getRawInput();
            $data = [
                'nama_pengeluaran' => $input['nama_pengeluaran'],
                'jumlah_pengeluaran' => $input['jumlah_pengeluaran'],
                'tanggal_bulan_tahun' => $input['tanggal_bulan_tahun'],
                'catatan_pengeluaran' => $input['catatan_pengeluaran']
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
        $model = new RiwayatkuModel();
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