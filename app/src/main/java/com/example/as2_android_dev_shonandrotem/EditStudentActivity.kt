package com.example.as2_android_dev_shonandrotem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.as2_android_dev_shonandrotem.model.Model
import com.example.as2_android_dev_shonandrotem.model.Student
// Shon Hason - 316539352, Rotem Ziv- 209412279

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
        val studentPhone:String? = intent.getStringExtra("STUDENT_PHONE")
        val studentAddress:String? = intent.getStringExtra("STUDENT_ADDRESS")
        val studentIndex:Int = intent.getIntExtra("STUDENT_INDEX",-1)


        val editName:EditText? = findViewById(R.id.activity_edit_student_plain_text_name)
        val editID:EditText?=findViewById((R.id.activity_edit_student_plain_text_id))
        val editPhone:EditText?=findViewById(R.id.activity_edit_student_plain_text_phone)
        val editAddress:EditText?=findViewById(R.id.activity_edit_student_plain_text_address)
        editName?.setText(studentName)
        editID?.setText(studentId)
        editPhone?.setText(studentPhone)
        editAddress?.setText(studentAddress)
        val saveButton: Button = findViewById(R.id.activity_edit_student_btn_save)
        val cancelButton: Button = findViewById(R.id.activity_edit_student_btn_cancel)
        val saveMessage: TextView = findViewById(R.id.activity_edit_student_plaintext_save_message)
        val deleteButton:Button = findViewById(R.id.activity_edit_student_btn_delete)

        cancelButton.setOnClickListener{
            finish()
        }
        deleteButton.setOnClickListener{
            if (studentIndex < 0 || studentIndex >= Model.instance.students.size)
            {
                Toast.makeText(this, "Error: Invalid student. Unable to delete.", Toast.LENGTH_SHORT).show()

            }
            Model.instance.deleteStudent(studentIndex)
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)



        }


        saveButton.setOnClickListener {
            val nameOfNewStudent = editName?.text.toString()
            val idOfNewStudent = editID?.text.toString()
            val phoneOfNewStudent = editPhone?.text.toString()
            val addressOfNewStudent = editAddress?.text.toString()

            // Check if studentIndex is valid
            if (studentIndex < 0 || studentIndex >= Model.instance.students.size) {
                saveMessage.setText("Invalid student index. Unable to update student.")
                return@setOnClickListener
            }
            if (nameOfNewStudent.isBlank() || idOfNewStudent.isBlank()) {
                saveMessage.setText( "Please fill in both Name and ID fields.")
                return@setOnClickListener
            }

            val studentToUpdate = Model.instance.students[studentIndex]

            studentToUpdate.name = nameOfNewStudent
            studentToUpdate.id = idOfNewStudent
            studentToUpdate.phoneNu = phoneOfNewStudent
            studentToUpdate.Address= addressOfNewStudent


                Model.instance.updateStudent(studentIndex, studentToUpdate)

                saveMessage.setText("Name: ${nameOfNewStudent} ID: ${idOfNewStudent} is updated and saved!")



                val intent = Intent(this, StudentsRecyclerViewActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)


            }
        }





    }


