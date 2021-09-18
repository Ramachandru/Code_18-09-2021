package com.ram.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ram.myapplication.viewmodel.RepoViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyler = findViewById<RecyclerView>(R.id.recycle)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        val repoAdapter = RepoAdapter(this@MainActivity)
        repoAdapter.dispData(mutableListOf())
        val viewmodel = ViewModelProvider(this@MainActivity).get(RepoViewModel::class.java)
        viewmodel.getReposData()?.observe(this, Observer { data ->
            repoAdapter.dispData(data)
            repoAdapter.notifyDataSetChanged()
        })
        recyler.layoutManager = linearLayoutManager
        recyler.adapter = repoAdapter
    }
}