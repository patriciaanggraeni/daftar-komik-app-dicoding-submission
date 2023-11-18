package com.example.aplikasi_sederhana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasi_sederhana.databinding.GenreCardBinding

class GenreAdapter: RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var comics = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapter.ViewHolder {
        val binding = GenreCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreAdapter.ViewHolder, position: Int) {
        val comic = comics[position]
        holder.bind(comic)

    }

    override fun getItemCount() = comics.size

    class ViewHolder(private val binding: GenreCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(comicGenre: String) {
            binding.apply {
                genre.text = comicGenre
            }
        }
    }

    fun setAdapter(comics: List<String>) {
        this.comics = comics
    }
}