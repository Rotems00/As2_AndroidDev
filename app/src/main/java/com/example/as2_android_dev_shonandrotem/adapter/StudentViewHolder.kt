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
    private var editButtonAction: Button? = null


    init {

        nameTextView = itemView.findViewById(R.id.student_row_list_textView_name)
        idTextView=itemView.findViewById(R.id.student_row_list_textView_id)
        checkBox = itemView.findViewById(R.id.student_row_list_checkBox)
        editButtonAction = itemView.findViewById(R.id.action_button_edit_profile)
        editButtonAction?.isEnabled = false

        checkBox?.apply {
            setOnClickListener{
                view -> (tag as? Int)?.let {
                    student?.isChecked = (view as? CheckBox)?.isChecked ?:false
                    if(student?.isChecked==true)
                    {
                        editButtonAction?.isEnabled = true;


                    }


                }
            }
        }




    }


    fun bind(student: Student?, position: Int)
    {

        this.student = student
        nameTextView?.text = student?.name
        idTextView?.text = student?.id

        checkBox?.apply {
            isChecked = student?.isChecked?: false
            tag = position
            editButtonAction?.isEnabled = isChecked

        }
        checkBox?.setOnCheckedChangeListener { _, isChecked ->

            student?.isChecked = isChecked


            editButtonAction?.isEnabled = student?.isChecked?:false
            editButtonAction?.setOnClickListener{
                val intent = Intent(itemView.context,EditStudentActivity::class.java)
                intent.putExtra("STUDENT_ID", student?.id)
                intent.putExtra("STUDENT_NAME", student?.name)
                intent.putExtra("INDEX",position)
                itemView.context.startActivity(intent)
            }
        }


    }

}