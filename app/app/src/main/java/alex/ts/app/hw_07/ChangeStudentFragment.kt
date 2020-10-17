package alex.ts.app.hw_07

import alex.ts.app.R
import alex.ts.app.hw_07.const.TO_CHANGE_STUDENT
import alex.ts.app.hw_07.model.Student
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_change_student.*

class ChangeStudentFragment : Fragment(), View.OnClickListener {
    private lateinit var myListener: MyListener
    private lateinit var student: Student

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            myListener = context as MyListener
        } catch (e: ClassCastException) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_change_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hw7BtnEdit.setOnClickListener(this)
        hw7BtnDelete.setOnClickListener(this)
        getBundleFromActivity()
    }

    private fun getBundleFromActivity() {
        if (arguments != null && arguments!!.containsKey(TO_CHANGE_STUDENT)) {
            student = arguments!!.getSerializable(TO_CHANGE_STUDENT) as Student
            hw7ChangeName.setText(student.name)
            hw7ChangeSurname.setText(student.surname)
            hw7ChangeId.setText(student.uuid.toString())
        }
    }

    interface MyListener {
        fun editableStudent(student: Student)
        fun removeStudent(student: Student)
    }

    override fun onClick(view: View?) {
        when (view) {
            hw7BtnEdit -> {
                val name = hw7ChangeName.text.toString()
                val surname = hw7ChangeSurname.text.toString()
                if (name.isEmpty() || surname.isEmpty()) {
                    Toast.makeText(requireContext(), "Fill in all the fields", Toast.LENGTH_SHORT)
                        .show()
                    return
                } else {
                    student.name = name
                    student.surname = surname
                    myListener.editableStudent(student)
                    activity!!.supportFragmentManager.beginTransaction()
                        .remove(this).commit()
                }
            }
            hw7BtnDelete -> {
                myListener.removeStudent(student)
                activity!!.supportFragmentManager.beginTransaction()
                    .remove(this).commit()
            }


        }
    }
}