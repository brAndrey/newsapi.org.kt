package com.example.myapplication561461084.data.news.NewsRepozitories


import com.example.myapplication561461084.data.news.Api.Interface.NewsApiService
import com.example.myapplication561461084.data.news.NewsListResponse
import io.reactivex.Observable
import retrofit2.Call

class NewsRepositories(var apiService: NewsApiService) {

    //@Query("country") ru:String,
    //@Query("apiKey") apiKey:String

    fun getNewsObservable(countryS:String, apiKeyS:String ): Observable<NewsListResponse> {
        return apiService.getNewsObservable(country = countryS, apiKey=apiKeyS)
    }

    fun getNewsCallString(countryS:String, apiKeyS:String ): Call<String> {
        return apiService.getNewsCallString(country = countryS, apiKey=apiKeyS)
    }
}