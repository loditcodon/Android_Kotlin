package vn.edu.hust.roomexample

import android.R
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.hust.roomexample.databinding.ActivityAddStudentBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.*

class AddStudent : AppCompatActivity() {
    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAutoCompleteTextView()
        setupDatePicker()

        binding.addBtn.setOnClickListener {
            if (isFormValid()) {
                addStudent()
            } else {
                showToast("Please fill in all fields")
            }
        }
    }

    private fun setupAutoCompleteTextView() {
        val city = resources.getStringArray(vn.edu.hust.roomexample.R.array.cities)
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

    private fun isFormValid(): Boolean {
        with(binding) {
            return inputFullname.text.isNotEmpty() &&
                    inputHometown.text.isNotEmpty() &&
                    birthdayInput.text.isNotEmpty() &&
                    inputMssv.text.isNotEmpty()
        }
    }

    private fun addStudent() {
        with(binding) {
            val newStudent = Student(
                mssv = inputMssv.text.toString(),
                fullName = inputFullname.text.toString(),
                dob = birthdayInput.text.toString(),
                hometown = inputHometown.text.toString()
            )
            val res = StudentDatabase.getInstance(application).studentDao().insertStudent(newStudent)
            showToast("Add student successfully")
            navigateToMainActivity()
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
