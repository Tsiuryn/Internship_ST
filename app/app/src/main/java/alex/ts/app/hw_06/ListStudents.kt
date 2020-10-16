package alex.ts.app.hw_06

import alex.ts.app.hw_06.model.Student
import java.util.*
import kotlin.collections.ArrayList

object ListStudents {
        fun getList(): List<Student> {
            return fillList(ArrayList<Student>())
        }

        private fun fillList(list: ArrayList<Student>): List<Student> {
            val myList = list
            myList.add(Student(UUID.randomUUID(), "Sacha", "Tec"))
            myList.add(Student(UUID.randomUUID(), "Petya", "Pet"))
            myList.add(Student(UUID.randomUUID(), "Serg", "Serg"))
            myList.add(Student(UUID.randomUUID(), "Andrey", "And"))
            myList.add(Student(UUID.randomUUID(), "Anton", "Ant"))
            myList.add(Student(UUID.randomUUID(), "Vlad", "Vl"))
            return myList
        }

}