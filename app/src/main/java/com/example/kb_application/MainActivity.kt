package com.example.kb_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sign_up_btn: Button = findViewById(R.id.sign_up_btn)
        sign_up_btn.setOnClickListener {
            val Intent = Intent(this,SignUpActivity::class.java)
            startActivity(Intent)
        }
    }
}