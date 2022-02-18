package com.example.myapplication561461084.NotUse

import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.data.api_github_com.Movie_api
import com.example.myapplication561461084.data.news.NewsListResponse
import io.reactivex.Observable
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
//import io.reactivex.rxjava3.core.Observable
//import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Query

public interface TXTSimplifiedApiService {

    @GET("marvel")
    fun getMovieListCall(): Call<MutableList<Movie_api>>

    @GET("marvel")
    fun getMovieListObservable(): Observable<MutableList<Movie_api>>

    @GET("marvel")
    fun getMovieListSingle(): Single<MutableList<Movie_api>>

    @GET("marvel")
    fun getMovieString(): Call<String>

    @GET("messages1.json")
    fun getObservableString(): Observable<String>

    @GET("messages1.json")
    fun getMessageString(): Call<String>

    @GET("/v2/top-headlines")
    fun getNewsCallString(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Call<String>

    @GET("/v2/top-headlines")
    fun getNewsObservableString(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Observable<NewsListResponse>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    companion object Factory {

        fun create(): TXTSimplifiedApiService {
            val baseURL = Constant.NEWS_BASE_URI

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

            return retrofit.create(TXTSimplifiedApiService::class.java)
            //.baseUrl(baseURL)
            //.addConverterFactory(ScalarsConverterFactory.create())
            //.addConverterFactory(GsonConverterFactory.create())
            //.baseUrl("https://rawgit.com/startandroid/data/master/messages/")
        }
    }

}