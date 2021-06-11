<?php namespace App\Models;
 
use CodeIgniter\Model;
 
class RiwayatkuModel extends Model
{
    protected $table = 'tabel_riwayat';
    protected $primaryKey = 'id_riwayat';
    protected $allowedFields = ['nama_pengeluaran','jumlah_pengeluaran','tanggal_bulan_tahun','catatan_pengeluaran'];
}