package alex.ts.app.hw_07.adapter
import alex.ts.app.R
import alex.ts.app.hw_07.model.Student
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_student.view.*

class ListStudentsAdapter(
    private var itemList: ArrayList<Student>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<ListStudentsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        )

    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val student = itemList[position]
        holder.id.text = "Id: ${student.uuid}"
        holder.name.text = "Name: ${student.name}"
        holder.surname.text = "Surname: ${student.surname}"
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(student)
        }
    }

    fun updateAdapter(list: ArrayList<Student>){
        itemList = list
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.hw6ItemId
        val name = itemView.hw6ItemName
        val surname = itemView.hw6ItemSurname
    }

    interface OnClickListener {
        fun onItemClick(student: Student)
    }
}