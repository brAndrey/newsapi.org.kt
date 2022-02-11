package com.example.myapplication561461084

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.UI.ThirdActivity.Adapter.MyMovieAdapter
import com.example.myapplication561461084.data.simplifiedcoding.Common.Common
import com.example.myapplication561461084.data.simplifiedcoding.Interface.RetrofitServices
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback


class ThirdActivity:AppCompatActivity(),TestInterface {

    lateinit var mService:RetrofitServices
    lateinit var layoutManager:LinearLayoutManager
    lateinit var adapter: MyMovieAdapter

    lateinit var recyclerMovieList:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        PrintString(javaClass.simpleName)

        mService= Common.retrofitServices
        recyclerMovieList= findViewById(R.id.recyclerMovieList)
        recyclerMovieList.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recyclerMovieList.layoutManager= layoutManager

        getAllMovieList()

    }

    private fun getAllMovieList() {

        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Log.i("getAllMovieList","onFailure")
            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                Log.i("getAllMovieList","onResponse")
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

            }
        })

}



}
