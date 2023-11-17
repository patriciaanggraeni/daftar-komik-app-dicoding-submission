package com.example.aplikasi_sederhana.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.adapter.ComicAdapter
import com.example.aplikasi_sederhana.databinding.FragmentHomeBinding
import com.example.aplikasi_sederhana.sedeer.ComicSeeder

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var comicAdapter: ComicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        comicAdapter = ComicAdapter()
        comicAdapter.setAdapter(ComicSeeder.seed(requireContext()))

        return binding.root
    }
}