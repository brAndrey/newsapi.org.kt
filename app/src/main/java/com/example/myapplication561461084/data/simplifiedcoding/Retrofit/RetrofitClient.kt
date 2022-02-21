package com.example.myapplication561461084.data.simplifiedcoding.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// класс siglton по созданию retrofit

object RetrofitClient {

    private var retrofit:Retrofit?=null

    fun getClient(baseURL:String):Retrofit{
        if (retrofit == null) // этой строчкой делаем класс сиглтоном
        {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
            return retrofit!!
    }

}