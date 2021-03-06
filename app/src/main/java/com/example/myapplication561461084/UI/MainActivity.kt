package com.example.myapplication561461084.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication561461084.ThirdActivity
import com.example.myapplication561461084.UI.Interface.TestInterface
import com.example.myapplication561461084.databinding.ActivityMainBinding

// https://habr.com/ru/post/336034/

class MainActivity : AppCompatActivity(), TestInterface {
    private lateinit var binding: ActivityMainBinding

    //https://habr.com/ru/post/520544/

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

        binding.buttonThird.setOnClickListener{startActivity(Intent(this, ThirdActivity::class.java))}

        binding.buttonFourth.setOnClickListener{startActivity(Intent(this, FourthActivity::class.java))}

    }

    fun overActivity() {

        val intent = Intent(this, SecondActivity::class.java)

        startActivity(intent)

    }
}