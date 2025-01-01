package com.example.as2_android_dev_shonandrotem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.as2_android_dev_shonandrotem.model.Model
import com.example.as2_android_dev_shonandrotem.model.Student

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val studentName:String? = intent.getStringExtra("STUDENT_NAME")
        val studentId:String? = intent.getStringExtra("STUDENT_ID")
        val studentIndex:Int = intent.getIntExtra("INDEX",-1)


        val editName:EditText? = findViewById(R.id.activity_edit_student_plain_text_name)
        val editID:EditText?=findViewById((R.id.activity_edit_student_plain_text_id))
        editName?.setText(studentName)
        editID?.setText(studentId)
        val saveButton: Button = findViewById(R.id.activity_edit_student_btn_save)
        val cancelButton: Button = findViewById(R.id.activity_edit_student_btn_cancel)
        val saveMessage: TextView = findViewById(R.id.activity_edit_student_plaintext_save_message)

        cancelButton.setOnClickListener{
            finish()
        }

        saveButton.setOnClickListener {
            val nameOfNewStudent = editName?.text.toString()
            val idOfNewStudent = editID?.text.toString()

            // Check if studentIndex is valid
            if (studentIndex == -1) {
                saveMessage.text = "INVALID STUDENT INDEX"
                return@setOnClickListener
            }

            val studentToUpdate = Model.instance.students[studentIndex]

            if (nameOfNewStudent.isNotBlank() && idOfNewStudent.isNotBlank()) {

                studentToUpdate.name = nameOfNewStudent
                studentToUpdate.id = idOfNewStudent


                Model.instance.updateStudent(studentIndex, studentToUpdate)


                saveMessage.text = "Name: ${nameOfNewStudent} ID: ${idOfNewStudent} is updated and saved!"


                val intent = Intent(this, MainActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                finish()
            } else {
                saveMessage.text = "Please fill in both Name and ID."
            }
        }





    }

    }
