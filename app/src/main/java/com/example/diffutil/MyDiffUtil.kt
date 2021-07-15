package com.example.diffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList: List<Student>,
    private val newList: List<Student>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id == newList[newItemPosition].id -> true
            oldList[oldItemPosition].name == newList[newItemPosition].name -> true
            else -> false
        }
    }
}