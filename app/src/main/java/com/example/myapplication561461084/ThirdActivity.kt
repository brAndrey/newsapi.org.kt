package com.example.myapplication561461084

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.UI.Interface.TestInterface
import com.example.myapplication561461084.UI.ThirdActivity.Adapter.MyMovieAdapter
import com.example.myapplication561461084.data.simplifiedcoding.Common.Common
import com.example.myapplication561461084.data.simplifiedcoding.Interface.RetrofitServices
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback


class ThirdActivity:AppCompatActivity(), TestInterface {

    lateinit var retrofitServices:RetrofitServices
    lateinit var layoutManager:LinearLayoutManager
    lateinit var myMovieAdapter: MyMovieAdapter

    lateinit var recyclerMovieList:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        PrintString(javaClass.simpleName)

        retrofitServices= Common.retrofitServices
        recyclerMovieList= findViewById(R.id.recyclerMovieList)

        recyclerMovieList.setHasFixedSize(true)

        layoutManager= LinearLayoutManager(this)
        recyclerMovieList.layoutManager= layoutManager

        getAllMovieList()

    }

    private fun getAllMovieList() {

        //https://startandroid.ru/ru/blog/506-retrofit.html

        retrofitServices
            .getMovieList()
            .enqueue(object : Callback<MutableList<Movie>> {

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Log.i("getAllMovieList","onFailure")
            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                Log.i("onResponse","getAllMovieList")
                Log.i("onResponse", " "+response.isSuccessful())
                if (response.isSuccessful()) {
                    Log.i("onResponse", "response body " + response.body()?.size);
                } else {
                    Log.i("onResponse","response code " + response.code());
                }

                myMovieAdapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                myMovieAdapter.notifyDataSetChanged()
                recyclerMovieList.adapter = myMovieAdapter

            }
        })

}



}
