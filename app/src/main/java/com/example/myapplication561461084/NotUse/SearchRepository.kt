package com.example.myapplication561461084.NotUse

import com.example.myapplication561461084.NotUse.TXTSimplifiedApiService
import com.example.myapplication561461084.data.api_github_com.Movie_api
import com.example.myapplication561461084.data.news.NewsListResponse
import io.reactivex.Observable
import io.reactivex.Single
//import io.reactivex.rxjava3.core.Observable
//import io.reactivex.rxjava3.core.Single

import retrofit2.Call


class SearchRepository(val apiServiceTXT: TXTSimplifiedApiService) {

    /*fun searchUsers(location: String, language: String): Observable<Result> {
        //return apiService.search(query = "location:$location+language:$language")
       return apiService.search(query = "location:$location+language:$language",)
    }*/

    fun seachMovieListObservable(): Observable<MutableList<Movie_api>> {
        return apiServiceTXT.getMovieListObservable()
    }

    fun getNewsObservableString(countryS:String, apiKeyS:String ):Observable<NewsListResponse>{
        //@Query("country") ru:String,
        //                      @Query("apiKey") apiKey:String
        return apiServiceTXT.getNewsObservableString(country = countryS, apiKey=apiKeyS)
    }
    fun getNewsCallString(countryS:String, apiKeyS:String ):Call<String>{
        //@Query("country") ru:String,
        //                      @Query("apiKey") apiKey:String
        return apiServiceTXT.getNewsCallString(country = countryS, apiKey=apiKeyS)
    }


    fun seachMovieStringObservable(): Observable<String> {
        return apiServiceTXT.getObservableString()
    }

    fun seachMovieCall(): Call<MutableList<Movie_api>> {
        return apiServiceTXT.getMovieListCall()
    }

    fun seachMessageCall(): Call<String> {
        return apiServiceTXT.getMessageString()
    }

    fun seachMovieSingle(): Single<MutableList<Movie_api>> {
        return apiServiceTXT.getMovieListSingle()
    }

    fun seachMovieString(): Call<String> {
        return apiServiceTXT.getMovieString()
    }

}