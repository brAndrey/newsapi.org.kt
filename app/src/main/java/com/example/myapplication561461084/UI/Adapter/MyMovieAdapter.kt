package com.example.myapplication561461084.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.R
import com.example.myapplication561461084.UI.ViewModels.SimplifiedCodingViewModel
import com.example.myapplication561461084.data.simplifiedcoding.model.Movie
import com.squareup.picasso.Picasso



class MyMovieAdapter():RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    private var movieList = mutableListOf<Movie>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_name: TextView = itemView.findViewById(R.id.txt_title)
        val txt_team: TextView = itemView.findViewById(R.id.txt_team)
        val txt_createdby: TextView = itemView.findViewById(R.id.txt_description)

        fun bind(listItem: Movie) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${image}", Toast.LENGTH_SHORT)
                    .show()
            }

            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${txt_name.text}", Toast.LENGTH_SHORT).show()
                Toast.makeText(it.context, "нажал на ${txt_name.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun refreshingMovieList(list: MutableList<Movie>){
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val listItem = movieList[position]



        holder.bind(listItem)

        Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.txt_name.text=movieList[position].name
        holder.txt_team.text=movieList[position].team
        holder.txt_createdby.text=movieList[position].createdby

    }

    override fun getItemCount()=movieList.size



}