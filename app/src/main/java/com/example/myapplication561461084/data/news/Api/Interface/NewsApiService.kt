package com.example.myapplication561461084.data.news.Api.Interface

//import io.reactivex.rxjava3.core.Single
import com.example.myapplication561461084.data.Constant

import com.example.myapplication561461084.data.news.NewsListResponse
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//"http://newsapi.org/v2/top-headlines?country=ru&apiKey=124c03fe52cb42f58d1e562b6cc6a662";
// ? - должен добавится автоматически т.к. есть параметры
// & - должен добавится автоматически т.к. параметров 2
interface NewsApiService {

    @GET("/v2/top-headlines")
    fun NewsListResponse(@Query("country") ru: String?,
                    @Query("apiKey") apiKey: String?): Single<NewsListResponse>

    @GET("/v2/top-headlines")
    fun gatNewsList(
        @Query("country") ru: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsListResponse?>?

    @GET("/v2/top-headlines")
    fun gatDataList(): Call<NewsListResponse?>?

    @GET("/v2/top-headlines")
    fun getNewsCallString(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Call<String>

    @GET("/v2/top-headlines")
    fun getNewsObservable(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Observable<NewsListResponse>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    companion object Factory {

        fun create(): NewsApiService {
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

            return retrofit.create(NewsApiService::class.java)
            //.baseUrl(baseURL)
            //.addConverterFactory(ScalarsConverterFactory.create())
            //.addConverterFactory(GsonConverterFactory.create())

        }
    }
}