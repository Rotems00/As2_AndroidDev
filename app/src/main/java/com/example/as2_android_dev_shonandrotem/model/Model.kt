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
        val namesAndIds = listOf(
            Pair("John Doe", "S12345"),
            Pair("Jane Smith", "S12346"),
            Pair("Michael Brown", "S12347"),
            Pair("Emily Davis", "S12348"),
            Pair("Daniel Johnson", "S12349"),
            Pair("Sophia Wilson", "S12350"),
            Pair("David Miller", "S12351"),
            Pair("Olivia Taylor", "S12352"),
            Pair("James Anderson", "S12353"),
            Pair("Emma Thomas", "S12354"),
            Pair("Liam White", "S12355"),
            Pair("Ava Harris", "S12356"),
            Pair("Noah Martin", "S12357"),
            Pair("Isabella Lee", "S12358")
        )

        for (pair in namesAndIds) {
            val student = Student(
                name = pair.first,
                id = pair.second,
                avatarUrl = "", // Add URLs if needed
                isChecked = false
            )
            this.students.add(student)
        }
    }






}
