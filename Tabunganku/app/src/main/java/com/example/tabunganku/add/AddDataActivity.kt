package com.example.tabunganku.add

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.content.FileProvider
import com.example.tabunganku.R
import com.example.tabunganku.databinding.ActivityAddDataBinding
import com.example.tabunganku.home.HomeActivity
import java.io.File
import java.io.IOException

class AddDataActivity : AppCompatActivity() {
    private lateinit var addDataActivity: ActivityAddDataBinding

    companion object{
        private val KODE_GAMBAR_KAMERA = 1111
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDataActivity = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(addDataActivity.root)

        addDataActivity.btnAddStruck.setOnClickListener {
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, KODE_GAMBAR_KAMERA)
        }

        addDataActivity.save.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1111){
            var bmp = data?.extras?.get("data") as Bitmap?
            addDataActivity.imgTampil.setImageBitmap(bmp)
        }
    }
}