package vn.edu.hust.roomexample

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.hust.roomexample.databinding.ActivityDetailStudentBinding
import java.text.SimpleDateFormat
import java.util.*

class DetailStudent : AppCompatActivity() {
    private lateinit var binding: ActivityDetailStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentId = intent.getStringExtra("ID")?.toInt()
        studentId?.let { showStudentDetails(it) }

        setupAutoCompleteTextView()
        setupDatePicker()

        binding.deleteBtn.setOnClickListener {
            studentId?.let { deleteStudent(it) }
        }

        binding.updateBtn.setOnClickListener {
            studentId?.let { updateStudent(it) }
        }
    }

    private fun showStudentDetails(studentId: Int) {
        val student = StudentDatabase.getInstance(application).studentDao().getById(studentId)
        with(binding) {
            inputFullname.setText(student.fullName)
            inputMssv.setText(student.mssv)
            inputHometown.setText(student.hometown)
            birthdayInput.setText(student.dob)
        }
    }

    private fun setupAutoCompleteTextView() {
        val city = resources.getStringArray(R.array.cities)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.select_dialog_item, city)
        binding.inputHometown.setAdapter(adapter)
        binding.inputHometown.threshold = 1
    }

    private fun setupDatePicker() {
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        binding.birthdayBtn.setOnClickListener {
            DatePickerDialog(
                this,
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.birthdayInput.setText(sdf.format(myCalendar.time))
    }

    private fun deleteStudent(studentId: Int) {
        StudentDatabase.getInstance(application).studentDao().deleteById(studentId)
        showToast("Delete student successfully")
        navigateToMainActivity()
    }

    private fun updateStudent(studentId: Int) {
        with(binding) {
            if (inputFullname.text.isEmpty() || inputHometown.text.isEmpty()
                || birthdayInput.text.isEmpty()
                || inputHometown.text.isEmpty() || inputMssv.text.isEmpty()
            ) {
                showToast("Please fill in all fields")
            } else {
                val newStudent = Student(
                    id = studentId,
                    mssv = inputMssv.text.toString(),
                    fullName = inputFullname.text.toString(),
                    dob = birthdayInput.text.toString(),
                    hometown = inputHometown.text.toString()
                )
                val res = StudentDatabase.getInstance(application).studentDao().insertStudent(newStudent)
                showToast("Update student successfully")
                navigateToMainActivity()
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
