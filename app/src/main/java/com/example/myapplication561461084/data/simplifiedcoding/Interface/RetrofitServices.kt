package com.example.myapplication561461084.data.simplifiedcoding.Interface

import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>
}