package za.ac.iie.empowering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val courseName = intent.getStringExtra("courseName")
        val courseDetailTextView = findViewById<TextView>(R.id.courseDetailTextView)

        val courseDetails = when (courseName) {
            "First Aid" -> "Purpose: To provide first aid awareness and basic life support \n" +
                    "Content: \n" +
                    " \n" +
                    "• Wounds and bleeding \n" +
                    "• Burns and fractures \n" +
                    "• Emergency scene management \n" +
                    "• Cardio-Pulmonary Resuscitation (CPR) \n" +
                    "• Respiratory distress e.g., Choking, blocked airway "
            "Sewing" -> "Purpose: To provide alterations and new garment tailoring services   \n" +
                    "Content: \n" +
                    " \n" +
                    "• Types of stitches \n" +
                    "• Threading a sewing machine \n" +
                    "• Sewing buttons, zips, hems and seams \n" +
                    "• Alterations \n" +
                    "• Designing and sewing new garments"
            "Landscaping" -> "Purpose: To provide landscaping services for new and established gardens Content: \n" +
                    " \n" +
                    "• Indigenous and exotic plants and trees \n" +
                    "• Fixed structures (fountains, statues, benches, tables, built-in braai) \n" +
                    "• Balancing of plants and trees in a garden \n" +
                    "• Aesthetics of plant shapes and colours \n" +
                    "• Garden layout"
            "Life Skills" -> "Purpose: To provide skills to navigate basic life necessities \n" +
                    "Content:  \n" +
                    " \n" +
                    "• Opening a bank account \n" +
                    "• Basic labour law (know your rights) \n" +
                    "• Basic reading and writing literacy  \n" +
                    "• Basic numeric literacy"
            "Child Minding" -> "Fees: R750 \n" +
                    "Purpose: To provide basic child and baby care   \n" +
                    "Content: \n" +
                    " \n" +
                    "• birth to six-month old baby needs \n" +
                    "• seven-month to one year old needs \n" +
                    "• Toddler needs \n" +
                    "• Educational toys"
            "Cooking" -> "Fees: R750 \n" +
                    "Purpose: To prepare and cook nutritious family meals  \n" +
                    "Content:  \n" +
                    " \n" +
                    "• Nutritional requirements for a healthy body \n" +
                    "• Types of protein, carbohydrates and vegetables \n" +
                    "• Planning meals \n" +
                    "• Preparation and cooking of meals "
            "Garden Maintenance" -> "Fees: R750 \n" +
                    "Purpose: To provide basic knowledge of watering, pruning and planting in a domestic garden.  \n" +
                    "Content: \n" +
                    " \n" +
                    "• Water restrictions and the watering requirements of indigenous and exotic plants \n" +
                    "• Pruning and propagation of plants \n" +
                    "• Planting techniques for different plant types "
            else -> "No details available"
        }

        courseDetailTextView.text = courseDetails

        // Set up Back to Home button
        val backToHomeButton = findViewById<Button>(R.id.backToHomeButton)
        backToHomeButton.setOnClickListener {
            // Navigate to Home activity
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish() // Close the current activity
        }
    }
}
