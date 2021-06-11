package com.example.tabunganku.data.respons

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseRiwayat(

	@field:SerializedName("catatan_pengeluaran")
	val catatanPengeluaran: String? = null,

	@field:SerializedName("tanggal_bulan_tahun")
	val tanggalBulanTahun: String? = null,

	@field:SerializedName("jumlah_pengeluaran")
	val jumlahPengeluaran: String? = null,

	@field:SerializedName("id_riwayat")
	val idRiwayat: String? = null,

	@field:SerializedName("nama_pengeluaran")
	val namaPengeluaran: String? = null
):Parcelable
