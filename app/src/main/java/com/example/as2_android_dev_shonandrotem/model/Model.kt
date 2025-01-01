package com.example.as2_android_dev_shonandrotem.model

class Model  private  constructor(){
    // a singelton in kotlin

    val students:MutableList<Student> = ArrayList()
    fun updateStudent(position: Int, updatedStudent: Student) {
        students[position] = updatedStudent
    }


    companion object
    {

        val instance = Model()

    }

    init {
        for(i in 0 .. 13)
        {
            val student = Student(
                name = "Name $i",
                id ="Student ID:$i",
                avatarUrl = "",
                isChecked =false
            )
            this.students.add(student)

        }
    }






}
