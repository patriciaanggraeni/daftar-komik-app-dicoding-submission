package com.example.aplikasi_sederhana.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.databinding.ComicCardBinding
import com.example.aplikasi_sederhana.fragments.HomeFragmentDirections
import com.example.aplikasi_sederhana.models.Comic

class ComicAdapter: RecyclerView.Adapter<ComicAdapter.ViewHolder>() {

    private var comics = emptyList<Comic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicAdapter.ViewHolder {
        val binding = ComicCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicAdapter.ViewHolder, position: Int) {
        val comic = comics[position]
        holder.bind(comic, comic.genre)

        holder.comicCardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(comic)
            holder.comicCardView.findNavController().navigate(action)
        }

        holder.btnLikeComic.setOnClickListener {
            val like = !comic.like
            comic.like = like
            if (like) {
                holder.btnLikeComic.setImageResource(R.drawable.icn_liked)
            } else {
                holder.btnLikeComic.setImageResource(R.drawable.icn_like_black)
            }
        }
    }

    override fun getItemCount() = comics.size

    class ViewHolder(private val binding: ComicCardBinding): RecyclerView.ViewHolder(binding.root) {
        val comicCardView: ConstraintLayout = binding.comicCardview
        val btnLikeComic: ImageButton = binding.like

        fun bind(comic: Comic, comicGenre: List<String>) {
            val listGenre = comicGenre.joinToString(", ")
            binding.apply {
                image.load(comic.image)
                title.text = comic.title
                rating.text = comic.rating.toString()
                genre.text = listGenre
            }
        }
    }

    fun setAdapter(comics: List<Comic>) {
        this.comics = comics
    }
}