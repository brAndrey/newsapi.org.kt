package com.example.myapplication561461084

import android.util.Log

interface TestInterface {




    fun PrintString(enterName:String) {
        Log.i(javaClass.simpleName, enterName+" "+ " "+System.currentTimeMillis())
    }

}