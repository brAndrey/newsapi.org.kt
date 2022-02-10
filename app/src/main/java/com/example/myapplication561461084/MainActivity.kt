package com.example.myapplication561461084

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myapplication561461084.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),TestInterface {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)

        // Display application icon in the toolbar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        //supportActionBar!!.setLogo(R.drawable.app_icon)
        supportActionBar!!.setDisplayUseLogoEnabled(true)
        PrintString(javaClass.simpleName)

        //var textView = findViewById<TextView>(R.id.textView)
        //var imagView = findViewById<ImageButton>(R.id.imageBat)
        //var buton2 = findViewById<Button>(R.id.buttonScreen)

        var k=0
        binding.imageBat!!.setOnClickListener{
            k++
            binding.textView.text= k.toString()
        }
        binding.buttonScreen.setOnClickListener{ overActivity()}

    }

    fun overActivity() {

        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

    }
}