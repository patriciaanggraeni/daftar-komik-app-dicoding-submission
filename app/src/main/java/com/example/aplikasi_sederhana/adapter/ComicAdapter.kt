package com.example.aplikasi_sederhana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.aplikasi_sederhana.databinding.ComicCardBinding
import com.example.aplikasi_sederhana.models.Comic

class ComicAdapter: RecyclerView.Adapter<ComicAdapter.ViewHolder>() {

    private var comics = emptyList<Comic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicAdapter.ViewHolder {
        val binding = ComicCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicAdapter.ViewHolder, position: Int) {
        val comic = comics[position]
        holder.bind(comic)
    }

    override fun getItemCount() = comics.size

    class ViewHolder(private val binding: ComicCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(comic: Comic) {
            binding.apply {
                image.load(comic.image)
                title.text = comic.title
                genre.text = comic.genre
                rating.text = comic.rating.toString()
            }
        }
    }

    fun setAdapter(comics: List<Comic>) {
        this.comics = comics
    }
}