package com.example.myapplication561461084

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity(),TestInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        PrintString(javaClass.simpleName)

        val buton = findViewById<Button>(R.id.button2)
        buton.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
