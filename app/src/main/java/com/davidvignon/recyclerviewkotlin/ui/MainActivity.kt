package com.davidvignon.recyclerviewkotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidvignon.recyclerviewkotlin.TheListAdapter
import com.davidvignon.recyclerviewkotlin.data.Element
import com.davidvignon.recyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter= TheListAdapter()
        binding.textRv.adapter = adapter

        val elements = listOf(
            Element(1, "First element"),
            Element(2, "Second element"),
            Element(3, "Third element"),
            Element(4, "Fourth element"),
            Element(5, "Fifth element"),
            Element(6, "Sixth element")
        )
        adapter.submitList(elements)


    }
}