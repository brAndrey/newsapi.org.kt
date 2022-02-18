package com.example.myapplication561461084.UI

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.security.NetworkSecurityPolicy
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.NotUse.SearchRepository
import com.example.myapplication561461084.R
import com.example.myapplication561461084.UI.Interface.FourthActivityInterface
import com.example.myapplication561461084.UI.ThirdActivity.Adapter.FourthActivityAdapter
import com.example.myapplication561461084.UI.ThirdActivity.Adapter.MyMovieAdapter
import com.example.myapplication561461084.data.news.NewsListItem
import com.example.myapplication561461084.data.news.NewsRepozitories.NewsRepositories
import com.example.myapplication561461084.data.news.Provider.NewsRepositoriesProvider
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FourthActivity : AppCompatActivity(), FourthActivityInterface {

    private val compositeDisposable = CompositeDisposable()
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerList: RecyclerView
    lateinit var recyclerAdapter:FourthActivityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        compositeDisposable.dispose()

        recyclerList = findViewById(R.id.fourth_recycler)
        layoutManager= LinearLayoutManager(this)
        recyclerList.layoutManager=layoutManager


        //ссылка с решением проблемы разрешения доступа по Api
        // https://koz.io/android-m-and-the-war-on-cleartext-traffic/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i("TAG_NetSecPolicy",""+ NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())


        }
        Log.i("TAG", " onCreate ")
        val repositoryRetrofitClient = NewsRepositoriesProvider.providerNewsRepository()
        //val repositoryRetrofitClient = SearchRepositoryProvider.providerSearchRepository()

          //seachMovieCall(repositoryRetrofitClient)

          //seachMovieString(repositoryRetrofitClient)

       // seachMessages1String(repositoryRetrofitClient)

        //seachObservable(repositoryRetrofitClient,compositeDisposable)

        //seachCallString(repositoryRetrofitClient)

        seachObservableString(repositoryRetrofitClient)


        val buton = findViewById<Button>(R.id.buttonOnFourth)
        buton.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun seachObservableString(repositoryRetrofitClient: NewsRepositories) {

       // try {
            //compositeDisposable.add(
                repositoryRetrofitClient.getNewsObservable(Constant.API_COUNTRY,Constant.API_KEY)

                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                    { mitRes ->
                        Log.i("mitRes", "Есть ")
                        Log.i("mitRes",""+mitRes.articles?.size)
                        //recyclerAdapter.setList()
                        recyclerAdapter = FourthActivityAdapter( mitRes.articles as MutableList<NewsListItem>)
                        recyclerList.adapter=recyclerAdapter

                        //MitResult ->                    Log.d("Result", "There are Java developers in Lagos")
                    }, { error ->
                            Log.i("mitRes", "error ")
                        error.printStackTrace()
                    })

          //  )
      //  } catch (e: Exception) {
      //      Log.i("TAG", "RX String - ")
      //  }
    }

    fun seachCallString(repositoryRetrofitClient: SearchRepository) {
        var TAG = "seachCallString"
        repositoryRetrofitClient.getNewsCallString(Constant.API_COUNTRY,Constant.API_KEY)
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
}







