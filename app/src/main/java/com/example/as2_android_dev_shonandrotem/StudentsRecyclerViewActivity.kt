package com.example.as2_android_dev_shonandrotem

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.as2_android_dev_shonandrotem.adapter.StudentsRecyclerViewAdapter
import com.example.as2_android_dev_shonandrotem.model.Model
import com.example.as2_android_dev_shonandrotem.model.Student

class StudentsRecyclerViewActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        students = Model.instance.students
        val recyclerView:RecyclerView = findViewById(R.id.activity_studentsRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = StudentsRecyclerViewAdapter(students)
        recyclerView.adapter = adapter



    }
}