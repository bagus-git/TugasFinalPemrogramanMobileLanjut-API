package com.example.tabunganku.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabunganku.R
import com.example.tabunganku.data.respons.ResponseRiwayat
import com.example.tabunganku.databinding.ListDataBinding
import java.util.ArrayList

class ListAdapter  : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var listData = ArrayList<ResponseRiwayat>()
    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallBack (onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    fun setData(bread: ArrayList<ResponseRiwayat>?) {
        if (bread == null) return
        listData.clear()
        listData.addAll(bread)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val listItemBinding = ListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = listData[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(private val binding: ListDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(list: ResponseRiwayat) {
            with(binding) {
                title.text = list.namaPengeluaran
                harga.text = list.jumlahPengeluaran
                tanggal.text = list.tanggalBulanTahun
            }
        }
    }

    interface OnItemClickCallBack{
        fun onItemClick(data: ResponseRiwayat)
    }
}