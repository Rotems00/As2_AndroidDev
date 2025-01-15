package com.example.as2_android_dev_shonandrotem

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
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
        val  editButton:Button = findViewById(R.id.activity_student_details_edit_button)


        val student_Name:String?= intent.getStringExtra("STUDENT_NAME")
        val student_Id:String? = intent.getStringExtra("STUDENT_ID")
        val student_PhoneNu:String? = intent.getStringExtra("STUDENT_PHONE")
        val student_Address:String? = intent.getStringExtra("STUDENT_ADDRESS")
        val student_CheckBox_Status:Boolean = intent.getBooleanExtra("STUDENT_CHECKED",false)
        val student_Index :Int=intent.getIntExtra("STUDENT_INDEX",-1)




        val nameText:TextView = findViewById(R.id.student_details_textview_name_added)
        val idText:TextView = findViewById(R.id.student_details_textview_id_added)
        val phoneText:TextView = findViewById(R.id.student_details_textview_phone_added)
        val addressText:TextView=findViewById(R.id.student_details_textview_address_added)
        val checkBoxFiller:CheckBox=findViewById(R.id.student_details_checkbox)
        val image:ImageView = findViewById(R.id.imageView2)



        image.setImageResource(R.drawable.man)

        nameText.text = Editable.Factory.getInstance().newEditable(student_Name) ?: "Unknown Name"
        idText.text = Editable.Factory.getInstance().newEditable(student_Id)?: "Unknown ID"
        phoneText.text = Editable.Factory.getInstance().newEditable(student_PhoneNu)?: "Unknown Phone Number"
        addressText.text = Editable.Factory.getInstance().newEditable(student_Address)?: "Unknown Address"
        checkBoxFiller.isChecked = student_CheckBox_Status
        checkBoxFiller.text = if (checkBoxFiller.isChecked) "CHECKED" else "UNCHECKED"

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_NAME",student_Name )
            intent.putExtra("STUDENT_ID",student_Id )
            intent.putExtra("STUDENT_PHONE", student_PhoneNu  )
            intent.putExtra("STUDENT_ADDRESS",  student_Address)
            intent.putExtra("STUDENT_INDEX", student_Index)


            startActivity(intent)
        }




    }
}