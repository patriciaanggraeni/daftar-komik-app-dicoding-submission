package com.example.aplikasi_sederhana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.databinding.LikedComicCardBinding
import com.example.aplikasi_sederhana.fragments.LikedFragmentDirections
import com.example.aplikasi_sederhana.models.Comic

class LikedComicAdapter: RecyclerView.Adapter<LikedComicAdapter.ViewHolder>() {

    private var likedComic = emptyList<Comic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedComicAdapter.ViewHolder {
        val binding = LikedComicCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikedComicAdapter.ViewHolder, position: Int) {
        val comic = likedComic[position]
        holder.bind(comic)

        holder.likedComic.setOnClickListener {
            val action = LikedFragmentDirections.actionLikedFragmentToDetailFragment(comic)
            holder.likedComic.findNavController().navigate(action)
        }

        if (comic.like) {
            holder.icnLikeComic.setImageResource(R.drawable.icn_liked)
        }
    }

    override fun getItemCount() = likedComic.size

    class ViewHolder(private val binding: LikedComicCardBinding): RecyclerView.ViewHolder(binding.root) {
        val likedComic = binding.likedComicCard
        val icnLikeComic = binding.likedComicIcon

        fun bind(comic: Comic) {
            binding.apply {
                likedComicImage.load(comic.image)
                likedComicTitle.text = comic.title
                ratingText.text = comic.rating.toString()
            }
        }
    }

    fun setAdapter(likedComic: List<Comic>) {
        this.likedComic = likedComic
    }
}