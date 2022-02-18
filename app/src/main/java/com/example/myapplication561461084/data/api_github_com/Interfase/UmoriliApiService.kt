package com.example.myapplication561461084.data.api_github_com.Interfase

import androidx.lifecycle.LiveData
import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.data.api_github_com.Model.UmoriliModel
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UmoriliApiService {

    @GET("/api/get")
    fun getData(
        @Query("name") resourseName: String?,
        @Query("num") count: Int,
    ): Call<List<UmoriliModel?>?>?

    @GET("/api/get")
    fun getPostModel(
        @Query("name") resourseName: String?,
        @Query("num") count: Int,
    ): Observable<List<UmoriliModel?>?>?

    @GET("/api/get")
    fun getPostModelLive(
        @Query("name") resourseName: String?,
        @Query("num") count: Int,
    ): Flowable<List<UmoriliModel?>?>?

    @GET("/api/get")
    fun getPostModelLiveData(
        @Query("name") resourseName: String?,
        @Query("num") count: Int,
    ): LiveData<List<UmoriliModel?>?>?

    companion object Factory {

        fun create(): UmoriliApiService {

            val baseURL= Constant.UMORILI_BASE_URI

            val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(UmoriliApiService::class.java)
        }
    }
}