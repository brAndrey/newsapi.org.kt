package com.example.myapplication561461084.data.news

import android.app.Application
import com.example.myapplication561461084.data.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class NewsApp:Application() {

    lateinit var newsApp: NewsApp

    override fun onCreate() {
        super.onCreate()

        configurationRetrofit()
    }

    private fun configurationRetrofit() {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.NEWS_BASE_URI)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        newsApp = retrofit.create(NewsApp::class.java)

    }
}