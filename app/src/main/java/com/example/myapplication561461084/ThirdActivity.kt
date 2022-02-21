package com.example.myapplication561461084

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.UI.Interface.TestInterface
import com.example.myapplication561461084.UI.Adapter.MyMovieAdapter
import com.example.myapplication561461084.UI.ViewModels.SimplifiedCodingViewModel
import com.example.myapplication561461084.data.simplifiedcoding.Common.Common
import com.example.myapplication561461084.data.simplifiedcoding.Interface.RetrofitServices
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback


class ThirdActivity : AppCompatActivity(), TestInterface {

    var TAG = "ThirdActivity "

    lateinit var retrofitServices: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var myMovieAdapter: MyMovieAdapter
    lateinit var recyclerMovieList: RecyclerView


    //https://dev.to/vtsen/recommended-ways-to-create-viewmodel-or-androidviewmodel-5e7k

    private val simplifiedCodingViewModel by lazy { ViewModelProvider(this).get(
        SimplifiedCodingViewModel::class.java)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        PrintString(javaClass.simpleName)

        Log.i(TAG + "onCreate", " " + System.currentTimeMillis())
        retrofitServices = Common.retrofitServices
        recyclerMovieList = findViewById(R.id.recyclerMovieList)

        recyclerMovieList.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        myMovieAdapter = MyMovieAdapter()
        recyclerMovieList.adapter = myMovieAdapter

        simplifiedCodingViewModel.modelList.observe(this, Observer{it?.let { myMovieAdapter.refreshingMovieList(it as MutableList<Movie>) }})


       // getAllMovieList()

    }

    private fun getAllMovieList() {

        //https://startandroid.ru/ru/blog/506-retrofit.html

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
                        Log.i("onResponse", "response body " + response.body()?.size);
                    } else {
                        Log.i("onResponse", "response code " + response.code());
                    }
                    myMovieAdapter = MyMovieAdapter()
                    myMovieAdapter.refreshingMovieList( response.body() as MutableList<Movie>)
                    myMovieAdapter.notifyDataSetChanged()
                    recyclerMovieList.adapter = myMovieAdapter
                }
            })


    }


}
