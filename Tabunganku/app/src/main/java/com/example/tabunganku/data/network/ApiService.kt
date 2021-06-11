package com.example.tabunganku.data.network

import com.example.tabunganku.data.respons.ResponsLogin
import com.example.tabunganku.data.respons.ResponseRiwayat
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("celenganku")
    fun postSignup(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password") re_entry_password: String,
    ): Call<ResponsLogin>

    @GET("riwayatku")
    fun getData(): Call<ArrayList<ResponseRiwayat>>

}