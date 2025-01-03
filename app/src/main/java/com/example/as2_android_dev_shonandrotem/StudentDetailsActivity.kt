package com.example.as2_android_dev_shonandrotem

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val student_name = intent.getStringExtra("STUDENT_NAME")
        val student_id = intent.getStringExtra("STUDENT_ID")

        val nameText:TextView = findViewById(R.id.student_details_textview_name_added)
        val idText:TextView = findViewById(R.id.student_details_textview_id_added)
        val image:ImageView = findViewById(R.id.imageView2)

        image.setImageResource(R.drawable.man)

        nameText.text = Editable.Factory.getInstance().newEditable(student_name)
        idText.text = Editable.Factory.getInstance().newEditable(student_id)
    }
}