package com.example.hw3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun Return(view: View) {
        val intent = Intent(this@MainActivity2, MainActivity::class.java)
        startActivity(intent)
    }

    fun Picture(view: View) {
        val intent = Intent(this@MainActivity2, MainActivity3::class.java)
        startActivity(intent)
    }
}