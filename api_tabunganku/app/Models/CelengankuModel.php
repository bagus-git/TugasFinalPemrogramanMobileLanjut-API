<?php namespace App\Models;
 
use CodeIgniter\Model;
 
class CelengankuModel extends Model
{
    protected $table = 'tabel_login';
    protected $primaryKey = 'id';
    protected $allowedFields = ['email','password','re_entry_password'];
}