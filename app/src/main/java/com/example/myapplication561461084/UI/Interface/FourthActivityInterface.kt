package com.example.myapplication561461084.UI.Interface

import android.util.Log
import com.example.myapplication561461084.data.api_github_com.Movie_api
import com.example.myapplication561461084.NotUse.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
//import io.reactivex.rxjava3.disposables.CompositeDisposable
//import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface FourthActivityInterface {

    fun seachMovieCall(repositoryRetrofitClient: SearchRepository) {
        var TAG = "seachMovieCall"
        repositoryRetrofitClient.seachMovieCall().enqueue(object :
            Callback<MutableList<Movie_api>> {

            override fun onFailure(call: Call<MutableList<Movie_api>>, t: Throwable) {
                Log.i(TAG, "onFailure")
            }

            override fun onResponse(
                call: Call<MutableList<Movie_api>>,
                response: Response<MutableList<Movie_api>>,
            ) {
                Log.i("TAG", "getAllMovieList")
                Log.i("TAG", " " + response.isSuccessful())
                if (response.isSuccessful()) {
                    Log.i("TAG", "response body " + response.body()?.size);
                } else {
                    Log.i("TAG", "response code " + response.code());
                }

            }
        }
        )

    }

    fun seachMessages1String(repositoryRetrofitClient: SearchRepository) {
        var TAG = "seachMessages1String"
        repositoryRetrofitClient.seachMessageCall()
            .enqueue(object : Callback<String> {

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.i(TAG, "onFailure String" + t)
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.i(TAG, "getAllMovieList String")
                    Log.i(TAG, " " + response.isSuccessful())
                    if (response.isSuccessful()) {
                        Log.i(TAG, "response body String body" + response.body().toString());
                    } else {
                        Log.i(TAG, "response code String code " + response.code());
                    }

                }
            })

    }

    fun seachMovieString(repositoryRetrofitClient: SearchRepository) {
        var TAG = "seachMovieString"
        repositoryRetrofitClient.seachMovieString()
            .enqueue(object : Callback<String> {

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.i(TAG, "onFailure String" + t)
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.i(TAG, "getAllMovieList String")
                    Log.i(TAG, " " + response.isSuccessful())
                    if (response.isSuccessful()) {
                        Log.i(TAG, "response body String body" + response.body().toString());
                    } else {
                        Log.i(TAG, "response code String code " + response.code());
                    }

                }
            })
    }


    fun seachMovieSingle(repositoryRetrofitClient: SearchRepository, compositeDisposable: CompositeDisposable) {

        try {
            compositeDisposable.add(
                repositoryRetrofitClient.seachMovieSingle()

                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

                    .subscribe({ mitRes ->
                        Log.i("mitRes", "Есть ")

                        //MitResult ->                    Log.d("Result", "There are Java developers in Lagos")
                    }, { error ->
                        error.printStackTrace()
                    })

            )
        } catch (e: Exception) {
            Log.i("TAG", "RX Single - ")
        }
    }

    fun seachObservable(repositoryRetrofitClient: SearchRepository, compositeDisposable:CompositeDisposable) {

        //try {
           // compositeDisposable.add(
                repositoryRetrofitClient.seachMovieListObservable()

                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

                    .subscribe({ mitRes ->
                        Log.i("mitRes", " "+mitRes.size+" Есть ")

                        //MitResult ->                    Log.d("Result", "There are Java developers in Lagos")
                    }, { error ->
                        {
                            Log.i("Obser", " is -")
                            error.printStackTrace()
                        }
                    })

            //)
//        } catch (e: Exception) {
//            Log.i("TAG", "RX - ")
//        }
    }
}