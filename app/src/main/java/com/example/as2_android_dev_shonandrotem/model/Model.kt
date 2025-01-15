package com.example.as2_android_dev_shonandrotem.model

class Model private constructor() {
    // A singleton in Kotlin

    val students: MutableList<Student> = ArrayList()

    fun updateStudent(position: Int, updatedStudent: Student) {
        if (position < 0 || position >= students.size) {
            throw IndexOutOfBoundsException("Invalid position: $position. Cannot update student.")
        }
        students[position] = updatedStudent
    }
    fun deleteStudent(position: Int)
    {
        if (position < 0 || position >= students.size) {
            throw IndexOutOfBoundsException("Invalid position: $position. Cannot delete student.")
        }
        this.students.removeAt(position)
    }

    companion object {
        val instance = Model()
    }

    init {
        val studentData = listOf(
            listOf("David Cohen", "S12345", "050-123-4567", "Herzl St 15, Tel Aviv"),
            listOf("Yael Levi", "S12346", "052-234-5678", "Dizengoff St 22, Tel Aviv"),
            listOf("Moshe Kaplan", "S12347", "054-345-6789", "Ben Yehuda St 12, Haifa"),
            listOf("Sara Shwartz", "S12348", "053-456-7890", "Jabotinsky St 7, Rishon Lezion"),
            listOf("Avi Mizrahi", "S12349", "050-567-8901", "Rabin Blvd 10, Jerusalem"),
            listOf("Noa Bar", "S12350", "052-678-9012", "Hagana St 3, Beer Sheva"),
            listOf("Eli Shimon", "S12351", "054-789-0123", "King George St 5, Tel Aviv"),
            listOf("Tamar Azulay", "S12352", "053-890-1234", "Hashalom Ave 8, Herzliya"),
            listOf("Yossi Peretz", "S12353", "050-901-2345", "Weizmann St 9, Ashdod"),
            listOf("Maya Azulay", "S12354", "052-012-3456", "Rothschild Blvd 4, Tel Aviv"),
            listOf("Haim Ben-David", "S12355", "054-123-4567", "Independence St 14, Eilat"),
            listOf("Shira Malka", "S12356", "053-234-5678", "HaNassi St 6, Netanya"),
            listOf("Itamar Levy", "S12357", "050-345-6789", "Bar Ilan St 11, Bnei Brak"),
            listOf("Roni Goldstein", "S12358", "052-456-7890", "Sderot St 17, Petah Tikva")
        )

        for (data in studentData) {
            val student = Student(
                name = data[0],
                id = data[1],
                phoneNu = data[2],
                Address = data[3],
                avatarUrl = "", // Add URLs if needed
                isChecked = false
            )
            this.students.add(student)
        }
    }

}
