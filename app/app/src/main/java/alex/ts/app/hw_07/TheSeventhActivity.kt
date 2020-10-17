package alex.ts.app.hw_07

import alex.ts.app.R
import alex.ts.app.hw_07.adapter.ListStudentsAdapter
import alex.ts.app.hw_07.const.NEW_STUDENT
import alex.ts.app.hw_07.const.REQUEST_FOR_ADD_STUDENT
import alex.ts.app.hw_07.const.TO_CHANGE_STUDENT
import alex.ts.app.hw_07.model.Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_the_seventh.*

class TheSeventhActivity : AppCompatActivity(), ChangeStudentFragment.MyListener {
    private var listStudent = ArrayList<Student>()
    private lateinit var adapter: ListStudentsAdapter
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_seventh)
        listStudent = ListStudents.getList() as ArrayList<Student>
        recycler = findViewById(R.id.hw7RecyclerListStudent)
        createAdapter(listStudent)
        hw7AddStudent.setOnClickListener { startAddedActivity() }
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
                    val bundle = Bundle()
                    val changeStudFrag = ChangeStudentFragment()
                    bundle.putSerializable(TO_CHANGE_STUDENT, student)
                    changeStudFrag.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.hw7Container, changeStudFrag)
                        .addToBackStack("this").commit()
                }
            })
        recycler.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (intent == null) return
        if (requestCode == REQUEST_FOR_ADD_STUDENT) {
            if (resultCode == Activity.RESULT_OK) {
                val student = intent.getSerializableExtra(NEW_STUDENT) as Student
                listStudent.add(student)
            }
            adapter.updateAdapter(listStudent)
        }
    }

    override fun editableStudent(student: Student) {
        for (i in 0 until listStudent.size) {
            if (listStudent[i].uuid == (student.uuid)) {
                listStudent.set(i, student)
            }
        }
        adapter.updateAdapter(listStudent)
    }

    override fun removeStudent(student: Student) {
        for (i in listStudent.size - 1 downTo 0) {
            if (listStudent[i].uuid == (student.uuid)) {
                listStudent.removeAt(i)
            }
        }
        adapter.updateAdapter(listStudent)
    }
}