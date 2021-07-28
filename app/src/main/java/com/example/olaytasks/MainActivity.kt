package com.example.olaytasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.olaytasks.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.data.observe(this) { data ->

            val adapter = MainAdapter(data)
            binding.recycler.layoutManager = LinearLayoutManager(this)
            binding.recycler.adapter = adapter
            binding.fab.setOnClickListener {
                viewModel.addNum()
            }
        }

    }

}