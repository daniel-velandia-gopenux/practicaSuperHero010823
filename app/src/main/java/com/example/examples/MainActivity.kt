package com.example.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examples.adapter.SuperHeroAdapter
import com.example.examples.databinding.ActivityMainBinding
import com.example.examples.model.SuperHero
import com.example.examples.model.SuperHeroProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var superHeroMutableList : MutableList<SuperHero> =
        SuperHeroProvider.superHeroList.toMutableList()

    private lateinit var adapter : SuperHeroAdapter

    private val linearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.btnAddHero.setOnClickListener { onClickAdd() }
    }

    private fun onClickAdd() {
        val superHero = SuperHero(
            "Iron Man",
            "Marvel",
            "Tony Stark",
            "https://i.pinimg.com/564x/e4/3d/8b/e43d8b9d446e6bceaef57133ca1a4e38.jpg"
        )

        superHeroMutableList.add(0, superHero)
        adapter.notifyItemInserted(0)
        linearLayoutManager.scrollToPositionWithOffset(0, 8)
    }

    private fun initRecyclerView() {
        initAdapter()
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = adapter

    }

    private fun initAdapter() {
        adapter = SuperHeroAdapter(
            superHeroList =  superHeroMutableList,
            onItemSelected = { onItemSelect(it) },
            onClickDelete = { onClickDelete(it) }
        )
    }

    private fun onItemSelect(superHero : SuperHero) {
        Toast.makeText(this, superHero.name, Toast.LENGTH_SHORT).show()
    }

    private fun onClickDelete(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)

    }
}