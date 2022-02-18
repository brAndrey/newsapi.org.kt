package com.example.myapplication561461084.UI.ThirdActivity.Adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication561461084.R
import com.example.myapplication561461084.data.news.NewsListItem
import com.squareup.picasso.Picasso

class FourthActivityAdapter(private var listView:MutableList<NewsListItem>): RecyclerView.Adapter<FourthActivityAdapter.FourthHolder>() {



    class FourthHolder(view: View):RecyclerView.ViewHolder(view){

        val image: ImageView = itemView.findViewById(R.id.image_movie)
        val txt_title: TextView = itemView.findViewById(R.id.txt_title)
        val txt_description: TextView = itemView.findViewById(R.id.txt_description)
        fun bind(elem:NewsListItem){}
    }

    fun setList(newList:MutableList<NewsListItem>) {
        listView = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FourthHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news_layout,parent,false)
        return FourthActivityAdapter.FourthHolder(itemView)
    }

    override fun onBindViewHolder(holder: FourthHolder, position: Int) {
      val item=listView[position]

        holder.bind(item)

        Picasso.get().load(listView[position].urlToImage).into(holder.image)
        holder.txt_title.text = listView[position].title
        holder.txt_description.text= Html.fromHtml(listView[position].description)
    }

    override fun getItemCount(): Int =  listView?.size

}