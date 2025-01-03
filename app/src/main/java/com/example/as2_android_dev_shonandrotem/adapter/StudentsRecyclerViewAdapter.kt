package com.example.as2_android_dev_shonandrotem.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater


import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.as2_android_dev_shonandrotem.R
import com.example.as2_android_dev_shonandrotem.StudentDetailsActivity
import com.example.as2_android_dev_shonandrotem.model.Student

class StudentsRecyclerViewAdapter(private val students:List<Student>?):RecyclerView.Adapter<StudentViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder
        {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(
                R.layout.students_list_single_row,
                parent,
                false)

            return StudentViewHolder(view)

        }

        override fun getItemCount(): Int {
            return students?.size ?: 0

        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.bind(students?.get(position), position)
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context,StudentDetailsActivity::class.java)
                intent.putExtra("STUDENT_NAME", students?.get(position)?.name)
                intent.putExtra("STUDENT_ID", students?.get(position)?.id)
                holder.itemView.context.startActivity(intent)

            }



        }

}

