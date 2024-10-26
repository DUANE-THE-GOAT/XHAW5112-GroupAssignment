package za.ac.iie.empowering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Navigate to Six-Month Courses
    fun goToSixMonthCourses(view: View) {
        val intent = Intent(this, CourseSummaryActivity::class.java)
        intent.putExtra("courseType", "six_month")
        startActivity(intent)
    }

    // Navigate to Six-Week Courses
    fun goToSixWeekCourses(view: View) {
        val intent = Intent(this, CourseSummaryActivity::class.java)
        intent.putExtra("courseType", "six_week")
        startActivity(intent)
    }
    fun goToCalculateFeesActivity(view: View) {
        val intent = Intent(this, CalculateFeesActivity::class.java)
        intent.putExtra("fees", "Fees")
        startActivity(intent)
    }
}