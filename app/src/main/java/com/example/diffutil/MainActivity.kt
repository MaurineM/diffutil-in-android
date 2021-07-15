package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val studentAdapter: StudentAdapter = StudentAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        updateDataWhenClicked()
        binding!!.recyclerview.apply {
            val newList: List<Student> = listOf(
                Student("1", "Milan Gans"),
                Student("2", "Renda Slaugh"),
                Student("3", "Basil Levison"),
                Student("4", "Tina Travers"),
            )
            adapter = studentAdapter.also { adapter ->
                adapter.setData(newList)
            }
        }
    }

    private fun updateDataWhenClicked() {
        binding!!.btnUpdate.setOnClickListener {
            val newList: List<Student> = listOf(
                Student("1", "Milan Gans"),
                Student("2", "Renda Slaugh"),
                Student("3", "Basil Levison"),
                Student("4", "Tina Travers"),
                Student("5", "Lil Mosey"),
                Student("6", "Maurine Alexa"),
            )
            studentAdapter.setData(newList)
        }
    }
}