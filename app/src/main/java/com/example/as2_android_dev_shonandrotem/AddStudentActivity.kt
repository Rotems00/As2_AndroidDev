package com.example.as2_android_dev_shonandrotem
// Shon Hason - 316539352, Rotem Ziv- 209412279

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.as2_android_dev_shonandrotem.model.Model
import com.example.as2_android_dev_shonandrotem.model.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val saveButton: Button = findViewById(R.id.activity_edit_student_btn_save)
        val cancelButton:Button = findViewById(R.id.activity_edit_student_btn_cancel)
        val nameEditText:EditText = findViewById(R.id.activity_edit_student_plain_text_name)
        val idEditText:EditText = findViewById(R.id.activity_edit_student_plain_text_id)
        val phoneEditText: EditText = findViewById(R.id.activity_edit_student_plain_text_phone)
        val addressEditText: EditText = findViewById(R.id.activity_edit_student_plain_text_address)
        val saveMessage: TextView = findViewById(R.id.activity_edit_student_plaintext_save_message)

        cancelButton.setOnClickListener{
            finish()
        }

        saveButton.setOnClickListener{
            val nameOfNewStudent = nameEditText.text.toString()
            val idOfNewStudent = idEditText.text.toString()
            val phoneOfNewStudent = phoneEditText.text.toString()
            val addressOfNewStudent = addressEditText.text.toString()
            if (nameOfNewStudent.isNotBlank() && idOfNewStudent.isNotBlank() && phoneOfNewStudent.isNotBlank() && addressOfNewStudent.isNotBlank()) {
                val newStudent = Student(
                    name = nameOfNewStudent,
                    id = idOfNewStudent,
                    phoneNu = phoneOfNewStudent,
                    Address = addressOfNewStudent,
                    avatarUrl = "",
                    isChecked = false
                )
                Model.instance.students.add(newStudent)
                saveMessage.text = "Name: $nameOfNewStudent, ID: $idOfNewStudent is saved!"
                val intent = Intent(this, StudentsRecyclerViewActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)

            } else {
                saveMessage.text = "Please fill in all fields."
            }







        }








    }
}