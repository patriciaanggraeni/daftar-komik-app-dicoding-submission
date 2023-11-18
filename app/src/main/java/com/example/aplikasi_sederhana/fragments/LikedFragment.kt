package com.example.aplikasi_sederhana.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.adapter.LikedComicAdapter
import com.example.aplikasi_sederhana.databinding.FragmentLikedBinding
import com.example.aplikasi_sederhana.models.Comic
import com.example.aplikasi_sederhana.sedeer.ComicSeeder

class LikedFragment : Fragment() {

    private lateinit var binding: FragmentLikedBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var likedComicAdapter: LikedComicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLikedBinding.inflate(inflater, container, false)

        likedComicAdapter = LikedComicAdapter()
        recyclerView = binding.likedComicRecyclerView

        return binding.root
    }
}