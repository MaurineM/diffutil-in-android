package com.example.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.StudentCardBinding

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.CardViewHolder>() {
    private var oldList = emptyList<Student>()

    inner class CardViewHolder(val card: StudentCardBinding) : RecyclerView.ViewHolder(card.root)

    override fun getItemCount(): Int = oldList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            StudentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.card.apply {
            studentId.text = oldList[position].id
            studentName.text = oldList[position].name
        }
    }

    fun setData(newList: List<Student>) {
        val diffUtil = MyDiffUtil(oldList, newList)
        val diffUtilResults = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffUtilResults.dispatchUpdatesTo(this)
    }
}