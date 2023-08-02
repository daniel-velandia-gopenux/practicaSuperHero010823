package com.example.examples.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examples.R
import com.example.examples.databinding.RecyclerViewSuperHeroBinding
import com.example.examples.model.SuperHero

class SuperHeroAdapter(
    private val superHeroList : List<SuperHero>,
    private val onItemSelected : (SuperHero) -> Unit,
    private val onClickDelete : (Int) -> Unit) : RecyclerView.Adapter<SuperHeroHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int): SuperHeroHolder {
        val binding = RecyclerViewSuperHeroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return SuperHeroHolder(binding)
    }

    override fun getItemCount() : Int = superHeroList.size

    override fun onBindViewHolder(holder : SuperHeroHolder, position : Int) {
        val item = superHeroList[position]
        holder.render(item, onItemSelected, onClickDelete)
    }
}