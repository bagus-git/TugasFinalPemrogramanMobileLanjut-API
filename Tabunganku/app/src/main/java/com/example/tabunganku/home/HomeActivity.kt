package com.example.tabunganku.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabunganku.add.AddDataActivity
import com.example.tabunganku.data.respons.ResponseRiwayat
import com.example.tabunganku.databinding.ActivityHomeBinding
import com.example.tabunganku.detail.DetailActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var dataAdapter: ListAdapter
    private lateinit var vieModel: ViewModelList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        dataAdapter = ListAdapter()

        vieModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ViewModelList::class.java)

        homeBinding.apply {
            rvList.layoutManager =
                LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
            rvList.setHasFixedSize(true)
            rvList.adapter = dataAdapter
        }
        vieModel.setData()
        vieModel.getData().observe(this, {
            if (it != null) {
                dataAdapter.setData(it)
            }
        })
        with(dataAdapter) {
            notifyDataSetChanged()
            setOnItemClickCallBack(object : ListAdapter.OnItemClickCallBack {
                override fun onItemClick(data: ResponseRiwayat) {
                    Intent(this@HomeActivity, DetailActivity::class.java).also {
                        it.putExtra(DetailActivity.DATA_ID, data.idRiwayat)
                        startActivity(it)
                    }
                }
            })
        }
        homeBinding.btnAdd.setOnClickListener {
            val intent=Intent(
                this, AddDataActivity::class.java
            )
            startActivity(intent)
        }
    }
}
