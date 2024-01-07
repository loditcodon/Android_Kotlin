package vn.edu.hust.roomexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val items: Array<Student>,
    private val listener: ItemClickListener?
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName = itemView.findViewById<TextView>(R.id.text_name)
        val studentMSSV = itemView.findViewById<TextView>(R.id.text_mssv)
        val studentMail = itemView.findViewById<TextView>(R.id.text_email)

        init {
            itemView.setOnClickListener {
                listener?.ItemClick(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    interface ItemClickListener {
        fun ItemClick(student: Student)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = items[position]

        holder.studentName.text = "Full name: ${currentStudent.fullName}"
        holder.studentMSSV.text = "MSSV: ${currentStudent.mssv}"

        val username = convertToUsername(currentStudent.fullName)
        holder.studentMail.text = "Email: $username${currentStudent.mssv}@sis.hust.edu.vn"
    }

    private fun convertToUsername(input: String): String {
        val words = input.split("\\s+".toRegex())
        val lastName = words.lastOrNull() ?: ""
        val firstLetters = words.dropLast(1).mapNotNull { it.firstOrNull()?.toString() }
        return "$lastName.${firstLetters.joinToString("").lowercase()}"
    }
}
