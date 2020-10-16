package alex.ts.app.hw_06

import alex.ts.app.R
import alex.ts.app.hw_06.const.NEW_STUDENT
import alex.ts.app.hw_06.model.Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_student.*
import java.util.*

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        hw6BtnAdd.setOnClickListener {
            addStudent()
        }
    }

    private fun addStudent() {
        val nameStudent = hw6AddName.text.toString()
        val surnameStudent = hw6AddSurname.text.toString()
        if (nameStudent.isEmpty() || surnameStudent.isEmpty()) {
            Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent()
            intent.putExtra(NEW_STUDENT, Student(UUID.randomUUID(), nameStudent, surnameStudent))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}