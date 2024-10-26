package za.ac.iie.empowering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class CourseSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_summary)
        val courseType = intent.getStringExtra("courseType")

        val courses = if (courseType == "six_month") {
            listOf("First Aid", "Sewing", "Landscaping", "Life Skills")
        } else {
            listOf("Child Minding", "Cooking", "Garden Maintenance")
        }

        val listView = findViewById<ListView>(R.id.courseListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, courses)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val courseName = courses[position]
            val intent = Intent(this, CourseDetailActivity::class.java)
            intent.putExtra("courseName", courseName)
            startActivity(intent)
        }
    }
}