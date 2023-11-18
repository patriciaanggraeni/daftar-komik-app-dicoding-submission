package com.example.aplikasi_sederhana.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.adapter.ChapterAdapter
import com.example.aplikasi_sederhana.adapter.GenreAdapter
import com.example.aplikasi_sederhana.databinding.FragmentDetailBinding
import com.example.aplikasi_sederhana.sedeer.ChapterSeeder
import com.example.aplikasi_sederhana.sedeer.ComicSeeder

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var genreAdapter: GenreAdapter
    private lateinit var chapterAdapter: ChapterAdapter

    private val comicData by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        genreAdapter = GenreAdapter()
        recyclerView = binding.genreRecyclerview
        binding.title.text = comicData.currentComic.title
        binding.image.load(comicData.currentComic.image)
        binding.imageCover.load(comicData.currentComic.image)
        binding.ratingText.text = comicData.currentComic.rating.toString()
        binding.description.text = resources.getText(comicData.currentComic.description)

        genreAdapter.setAdapter(comicData.currentComic.genre)
        recyclerView.apply {
            adapter = genreAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        if (comicData.currentComic.like) {
            binding.comicLiked.setImageResource(R.drawable.icn_liked)
            binding.likeComicText.text = "Disukai"
        } else {
            binding.comicLiked.setImageResource(R.drawable.icn_like_black)
            binding.likeComicText.text = "Suka"
        }

        recyclerView = binding.chapterRecyclerview
        chapterAdapter = ChapterAdapter()
        chapterAdapter.setAdapter(ChapterSeeder.chapterSeeder())

        recyclerView.apply {
            adapter = chapterAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        return binding.root
    }
}