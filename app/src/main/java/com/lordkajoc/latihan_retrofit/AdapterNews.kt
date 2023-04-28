package com.lordkajoc.latihan_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordkajoc.latihan_retrofit.databinding.ItemListNewsBinding
import com.lordkajoc.latihan_retrofit.model.GetAllNewsResponesItem

class AdapterNews(var listNews: List<GetAllNewsResponesItem>): RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    class ViewHolder(var binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitleNews.text = listNews[position].title
        holder.binding.tvTanggalnews.text = listNews[position].createdAt
        Glide.with(holder.itemView.context).load(listNews!![position].image).into(holder.binding.imageViewNews)

    }
    override fun getItemCount(): Int {
        return listNews.size
    }


}