package com.example.navigationdrawertest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navigationdrawertest.model.Article

class NewsAdapter(val context: Context, val article:List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    //for databinding -- rcv_singlerow layout is data binding layout
   // lateinit var binding: RcvSinglerowLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        //binding = DataBindingUtil.setContentView(r, R.layout.rcv_singlerow_layout)
        val view = LayoutInflater.from(context).inflate(R.layout.rcv_singlerow_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = article[position]
        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

    }

    override fun getItemCount(): Int {
        return article.size
    }

    //viewholder class
    class ArticleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var newsImage = itemView.findViewById<ImageView>(R.id.imageView)
        var newsTitle = itemView.findViewById<TextView>(R.id.textview1)
        var newsDescription = itemView.findViewById<TextView>(R.id.textview2)

    }

}