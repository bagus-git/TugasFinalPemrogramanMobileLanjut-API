package com.example.tabunganku.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tabunganku.BuildConfig.BASE_URL
import com.example.tabunganku.data.network.ApiConfig
import com.example.tabunganku.data.network.ApiService
import com.example.tabunganku.data.respons.ResponseRiwayat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelList: ViewModel() {
    val list = MutableLiveData<ArrayList<ResponseRiwayat>>()
    fun setData() {
        val data = ApiConfig.getApiService(BASE_URL).create(
            ApiService::class.java
        )
        data.getData().enqueue(object : Callback<ArrayList<ResponseRiwayat>> {
            override fun onResponse(
                call: Call<ArrayList<ResponseRiwayat>>,
                response: Response<ArrayList<ResponseRiwayat>>
            ) {
                if (response.isSuccessful) {
                    list.value = response.body()
                    println(list)
                }
            }
            override fun onFailure(call: Call<ArrayList<ResponseRiwayat>>, t: Throwable) {
                Log.e("LIST FOOD", "Failed: ${t.message.toString()}")
            }
        })
    }
    fun getData(): LiveData<ArrayList<ResponseRiwayat>> {
        return list
    }

}