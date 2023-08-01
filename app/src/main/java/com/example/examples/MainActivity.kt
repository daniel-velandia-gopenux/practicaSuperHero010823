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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SuperHeroAdapter(SuperHeroProvider.SuperHeroList) { onItemSelect(it) }
    }

    private fun onItemSelect(superHero: SuperHero) {
        Toast.makeText(this, superHero.name, Toast.LENGTH_SHORT).show()
    }
}