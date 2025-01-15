package com.example.as2_android_dev_shonandrotem.adapter

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.as2_android_dev_shonandrotem.EditStudentActivity
import com.example.as2_android_dev_shonandrotem.R
import com.example.as2_android_dev_shonandrotem.model.Student

class StudentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private  var nameTextView:TextView? = null
    private var idTextView: TextView?= null
    private var checkBox: CheckBox? =null
    private var student: Student? = null




    init {

        nameTextView = itemView.findViewById(R.id.student_row_list_textView_name)
        idTextView=itemView.findViewById(R.id.student_row_list_textView_id)
        checkBox = itemView.findViewById(R.id.student_row_list_checkBox)


    }


    fun bind(student: Student?, position: Int)
    {

        this.student = student
        nameTextView?.text = student?.name
        idTextView?.text = student?.id


        checkBox?.apply {
            isChecked = student?.isChecked?: false
            tag = position


        }
        checkBox?.setOnCheckedChangeListener { _, isChecked ->

            student?.isChecked = isChecked



        }


    }

}