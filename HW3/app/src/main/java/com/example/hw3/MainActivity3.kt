package com.example.hw3

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity3 : AppCompatActivity() {

    private lateinit var imv: ImageView
    private lateinit var btPicture: Button
    private lateinit var btSave: Button
    private var imageBitmap: Bitmap? = null

    private val takePictureLauncher = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview())
    { bitmap ->
        bitmap?.let {
            imageBitmap = it
            imv.setImageBitmap(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imv = findViewById(R.id.imv)
        btPicture = findViewById(R.id.btPicture)
        btSave = findViewById(R.id.btSave)

        btPicture.setOnClickListener {
            takePictureLauncher.launch(null)
        }

        btSave.setOnClickListener {
            imageBitmap?.let { bitmap ->
                saveImageToInternalStorage(bitmap)
            } ?: Toast.makeText(this, "No image to save!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun saveImageToInternalStorage(bitmap: Bitmap) {
        val folder = File(filesDir, "numbers")
        if (!folder.exists()) folder.mkdir()
        print(folder.getAbsolutePath())
        val filename = "image_${System.currentTimeMillis()}.jpg"
        val file = File(folder, filename)

        try {
            FileOutputStream(file).use { out ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
            }
            Toast.makeText(this, "Image saved in /numbers", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show()
        }
    }

}