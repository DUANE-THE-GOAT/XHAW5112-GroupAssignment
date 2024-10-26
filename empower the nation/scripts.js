// Function to validate the contact form
function validateContactForm() {
    const name = document.getElementById("name").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;

    if (!name || !phone || !email) {
        alert("Please fill in all fields.");
        return false;
    }

    // Basic email validation
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    return true;
}

// Function to update total fees based on selected courses
function updateTotalFees() {
    const checkboxes = document.querySelectorAll('input[name="courses"]:checked');
    const selectedCourses = Array.from(checkboxes).map(checkbox => checkbox.value);
    const prices = {
        "First Aid": 1500,
        "Sewing": 1500,
        "Landscaping": 1500,
        "Life Skills": 1500,
        "Child Minding": 750,
        "Cooking": 750,
        "Garden Maintenance": 750
    };

    let total = selectedCourses.reduce((sum, course) => sum + prices[course], 0);
    let discount = 0;

    // Apply discounts based on number of courses selected
    if (selectedCourses.length === 2) {
        discount = 0.05;
    } else if (selectedCourses.length === 3) {
        discount = 0.10;
    } else if (selectedCourses.length > 3) {
        discount = 0.15;
    }

    total -= total * discount; // Apply discount
    total += total * 0.15; // Add 15% VAT

    document.getElementById("total-amount").innerText = `Total: R${total.toFixed(2)}`;
}

// Function to handle form submission
function handleSubmit() {
    if (validateContactForm()) {
        // Here you could send the form data to a server or show a confirmation
        alert("Thank you for your submission! We will contact you soon.");
        // Optionally, reset the form or redirect
        document.getElementById("contact-form").reset();
    }
}

// Attach event listeners (this could also be done in the HTML with inline events)
document.getElementById("contact-form").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission
    handleSubmit();
});

// Optional: Add event listeners for checkboxes to update total on change
const courseCheckboxes = document.querySelectorAll('input[name="courses"]');
courseCheckboxes.forEach(checkbox => {
    checkbox.addEventListener('change', updateTotalFees);
});

// Initialize the total amount on page load
window.onload = function () {
    updateTotalFees(); // Call to update total fees on load
};
