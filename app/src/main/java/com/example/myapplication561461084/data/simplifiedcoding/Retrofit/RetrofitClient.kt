package com.example.myapplication561461084.data.simplifiedcoding.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// класс siglton по созданию retrofit

object RetrofitClient {

    private var retrofit:Retrofit?=null

    fun getClient(baseURL:String):Retrofit{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
            return retrofit!!
    }

}