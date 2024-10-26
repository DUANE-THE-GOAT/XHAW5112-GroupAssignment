package za.ac.iie.empowering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class CalculateFeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_fees)
    }

    fun calculateFees(view: View) {
        // Course prices
        val coursePrices = mapOf(
            "First Aid" to 1500,
            "Sewing" to 1500,
            "Landscaping" to 1500,
            "Life Skills" to 1500,
            "Child Minding" to 750,
            "Cooking" to 750,
            "Garden Maintenance" to 750
        )

        // Selected courses
        val selectedCourses = mutableListOf<String>()
        if (findViewById<CheckBox>(R.id.firstAidCheckBox).isChecked) selectedCourses.add("First Aid")
        if (findViewById<CheckBox>(R.id.sewingCheckBox).isChecked) selectedCourses.add("Sewing")
        if (findViewById<CheckBox>(R.id.landscapingCheckBox).isChecked) selectedCourses.add("Landscaping")
        if (findViewById<CheckBox>(R.id.lifeSkillsCheckBox).isChecked) selectedCourses.add("Life Skills")
        if (findViewById<CheckBox>(R.id.childMindingCheckBox).isChecked) selectedCourses.add("Child Minding")
        if (findViewById<CheckBox>(R.id.cookingCheckBox).isChecked) selectedCourses.add("Cooking")
        if (findViewById<CheckBox>(R.id.gardenMaintenanceCheckBox).isChecked) selectedCourses.add("Garden Maintenance")

        // Total cost before discount
        var totalFee = 0
        for (course in selectedCourses) {
            totalFee += coursePrices[course] ?: 0
        }

        // Apply discounts
        val discount = when (selectedCourses.size) {
            2 -> 0.05
            3 -> 0.10
            else -> if (selectedCourses.size > 3) 0.15 else 0.0
        }
        val discountedFee = totalFee - (totalFee * discount)

        // Apply VAT (15%)
        val vat = 0.15
        val totalWithVAT = discountedFee + (discountedFee * vat)

        // Display the total fee with VAT
        val totalFeeTextView = findViewById<TextView>(R.id.totalFeeTextView)
        totalFeeTextView.text = "Total Fee (incl. VAT): R${"%.2f".format(totalWithVAT)}"

        val backToHomeButton = findViewById<Button>(R.id.backToHomeButton1)
        backToHomeButton.setOnClickListener {
            // Navigate to Home activity
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish() // Close the current activity
        }
    }

}