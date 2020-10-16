package alex.ts.app.hw_06

import alex.ts.app.R
import alex.ts.app.hw_06.const.TO_CHANGE_STUDENT
import alex.ts.app.hw_06.const.EDIT_STUDENT
import alex.ts.app.hw_06.const.REMOVE_STUDENT
import alex.ts.app.hw_06.model.Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change_student.*

class ChangeStudentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var student: Student
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_student)
        student = intent.getSerializableExtra(TO_CHANGE_STUDENT) as Student
        hw6ChangeId.text = student.uuid.toString()
        hw6ChangeName.setText(student.name)
        hw6ChangeSurname.setText(student.surname)
        hw6BtnEdit.setOnClickListener(this)
        hw6BtnDelete.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view){
            hw6BtnEdit->{
                val name = hw6ChangeName.text.toString()
                val surname = hw6ChangeSurname.text.toString()
                if(name.isEmpty() || surname.isEmpty()){
                    Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show()
                    return
                }else{
                    val intent = Intent()
                    student.name = name
                    student.surname = surname
                    intent.putExtra(EDIT_STUDENT, student)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
            hw6BtnDelete ->{
                val intent = Intent()
                intent.putExtra(REMOVE_STUDENT, student)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}