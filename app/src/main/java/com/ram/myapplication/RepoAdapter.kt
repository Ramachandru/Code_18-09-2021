package com.ram.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ram.myapplication.databinding.RepoAdapterBinding
import com.ram.myapplication.model.Repose

class RepoAdapter constructor(context: Context) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    var mContext: Context? = null;

    init {
        mContext = context
    }

    var listData: MutableList<Repose>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoAdapter.RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val repoAdapterBinding = RepoAdapterBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(mContext!!, repoAdapterBinding)
    }

    fun dispData(listData: MutableList<Repose>) {
        this.listData = listData
    }

    override fun onBindViewHolder(holder: RepoAdapter.RepoViewHolder, position: Int) {
        val repose = listData!!.get(position)
        holder.showValuetxt(repose)
    }

    fun onClickedData(name: String) {
        Toast.makeText(mContext, "" + name, Toast.LENGTH_LONG).show()
    }

    override fun getItemCount(): Int {
        return listData!!.size
    }

    class RepoViewHolder(context: Context, binding: RepoAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var repoBinding = binding
        var ctx = context
        fun showValuetxt(repo: Repose) {
            repoBinding.repoInstance = repo
            repoBinding.adapter = RepoAdapter(ctx)
            repoBinding.executePendingBindings()
        }
    }
}