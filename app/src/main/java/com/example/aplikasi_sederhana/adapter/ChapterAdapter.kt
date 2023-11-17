package com.example.aplikasi_sederhana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasi_sederhana.R
import com.example.aplikasi_sederhana.databinding.ChapterCardBinding
import com.example.aplikasi_sederhana.models.Chapter

class ChapterAdapter: RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    private var chapters = emptyList<Chapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterAdapter.ViewHolder {
        val binding = ChapterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChapterAdapter.ViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.bind(chapter)
    }

    override fun getItemCount() = chapters.size

    class ViewHolder(private val binding: ChapterCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chapter: Chapter) {
            binding.chapterTitle.text = chapter.chapter
        }
    }

    fun setAdapter(chapters: List<Chapter>) {
        this.chapters = chapters
    }
}