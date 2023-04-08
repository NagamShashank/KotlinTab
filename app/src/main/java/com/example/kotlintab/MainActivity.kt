package com.example.kotlintab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintab.adapters.MyPageAdapter
import com.example.kotlintab.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ViewPager.adapter = MyPageAdapter( supportFragmentManager)
        binding.TabLayout.setupWithViewPager(binding.ViewPager)

    }
}