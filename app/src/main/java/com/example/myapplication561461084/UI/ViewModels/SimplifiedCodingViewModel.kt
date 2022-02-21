package com.example.myapplication561461084.UI.ViewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication561461084.data.simplifiedcoding.Common.Common
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SimplifiedCodingViewModel : ViewModel() {

    var modelList: MutableLiveData<List<Movie>> = MutableLiveData()

    var modelToast = MutableLiveData<String>()

    init {
        getData()
    }

    private fun getData() {

        //https://startandroid.ru/ru/blog/506-retrofit.html

        val retrofitServices = Common.retrofitServices

        retrofitServices
            .getMovieList()
            .enqueue(object : Callback<MutableList<Movie>> {

                override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                    Log.i("getAllMovieList", "onFailure")
                }

                override fun onResponse(
                    call: Call<MutableList<Movie>>,
                    response: Response<MutableList<Movie>>,
                ) {
                    Log.i("onResponse", "getAllMovieList")
                    Log.i("onResponse", " " + response.isSuccessful())
                    if (response.isSuccessful()) {
                        Log.i("onResponse", "response body " + response.body()?.size)
                        modelList.value = response.body() as MutableList<Movie>
                    } else {
                        Log.i("onResponse", "response code " + response.code());
                    }

                }
            })
    }

    fun SetToast(toast: String ){
        modelToast.value = toast
    }


}