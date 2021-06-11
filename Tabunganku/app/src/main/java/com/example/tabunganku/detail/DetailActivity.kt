package com.example.tabunganku.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tabunganku.R

class DetailActivity : AppCompatActivity() {
    companion object{
        const val DATA_ID = "data_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}