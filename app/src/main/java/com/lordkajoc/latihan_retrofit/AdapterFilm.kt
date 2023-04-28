package com.lordkajoc.latihan_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lordkajoc.latihan_retrofit.databinding.ItemListFilmBinding
import com.lordkajoc.latihan_retrofit.model.GetAllFIlmResponseItem

class AdapterFilm(var listFilm: List<GetAllFIlmResponseItem>): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    class ViewHolder(var binding: ItemListFilmBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitleNews.text = listFilm[position].name
        holder.binding.tvTanggalnews.text = listFilm[position].date
        Glide.with(holder.itemView.context).load(listFilm!![position].image).into(holder.binding.imageViewFilm)

    }
    override fun getItemCount(): Int {
        return listFilm.size
    }


}