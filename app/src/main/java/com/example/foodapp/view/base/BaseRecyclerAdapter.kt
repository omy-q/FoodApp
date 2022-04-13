package com.example.foodapp.view.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: MutableList<T> = mutableListOf()

    fun update(data: List<T>) {
        this.data.addAll(data)
    }

    fun setNewData(data: List<T>) {
        this.data = data.toMutableList()
    }

    fun getDataPosition(position: Int): T {
        return data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(data[position])
    }

    override fun getItemCount() = data.size

    abstract fun getViewHolder(viewGroup: ViewGroup): RecyclerView.ViewHolder
}