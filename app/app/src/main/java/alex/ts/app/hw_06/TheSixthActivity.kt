package alex.ts.app.hw_06

import alex.ts.app.R
import alex.ts.app.hw_06.adapter.ListStudentsAdapter
import alex.ts.app.hw_06.const.*
import alex.ts.app.hw_06.model.Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_the_sixth.*

class TheSixthActivity : AppCompatActivity() {
    private var listStudent = ArrayList<Student>()
    private lateinit var adapter: ListStudentsAdapter
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_sixth)
        listStudent = ListStudents.getList() as ArrayList<Student>
        recycler = findViewById(R.id.hw6RecyclerListStudent)
        createAdapter(listStudent)
        hw6AddStudent.setOnClickListener { startAddedActivity() }
    }

    private fun startAddedActivity() {
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivityForResult(intent, REQUEST_FOR_ADD_STUDENT)
    }

    private fun createAdapter(list: ArrayList<Student>) {
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = ListStudentsAdapter(
            list,
            object :
                ListStudentsAdapter.OnClickListener {
                override fun onItemClick(student: Student) {
                    val intent = Intent(this@TheSixthActivity, ChangeStudentActivity::class.java)
                    intent.putExtra(TO_CHANGE_STUDENT, student)
                    startActivityForResult(intent, REQUEST_FOR_EDIT_STUDENT)

                }

            })
        recycler.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (intent == null) return
        when (requestCode) {
            REQUEST_FOR_ADD_STUDENT -> {
                if (resultCode == Activity.RESULT_OK) {
                    val student = intent.getSerializableExtra(NEW_STUDENT) as Student
                    listStudent.add(student)
                }
            }
            REQUEST_FOR_EDIT_STUDENT -> {
                if (resultCode == Activity.RESULT_OK) {
                    val serStudent = intent.getSerializableExtra(EDIT_STUDENT)
                    if (serStudent != null) {
                        val student = serStudent as Student
                        for (i in 0 until listStudent.size) {
                            if (listStudent[i].uuid == (student.uuid)) {
                                listStudent.set(i, student)
                            }
                        }
                    }
                    val sezStudent = intent.getSerializableExtra(REMOVE_STUDENT)
                    if (sezStudent != null) {
                        val student = sezStudent as Student
                        for (i in listStudent.size - 1 downTo 0) {
                            if (listStudent[i].uuid == (student.uuid)) {
                                listStudent.removeAt(i)
                            }
                        }
                    }

                }
            }
        }
        adapter.updateAdapter(listStudent)
    }
}