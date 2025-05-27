const form = document.getElementById("registrationForm");
const nameInput = form.elements["name"];
const emailInput = form.elements["email"];
const eventSelect = form.elements["event"];

const nameError = document.getElementById("nameError");
const emailError = document.getElementById("emailError");
const eventError = document.getElementById("eventError");
const successMessage = document.getElementById("successMessage");

// Simple email regex for validation
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

form.addEventListener("submit", (event) => {
  event.preventDefault(); // Prevent form submission

  // Clear previous errors and message
  nameError.textContent = "";
  emailError.textContent = "";
  eventError.textContent = "";
  successMessage.textContent = "";

  let isValid = true;

  // Validate name
  if (!nameInput.value.trim()) {
    nameError.textContent = "Name is required.";
    isValid = false;
  }

  // Validate email
  if (!emailInput.value.trim()) {
    emailError.textContent = "Email is required.";
    isValid = false;
  } else if (!emailPattern.test(emailInput.value.trim())) {
    emailError.textContent = "Please enter a valid email.";
    isValid = false;
  }

  // Validate event selection
  if (!eventSelect.value) {
    eventError.textContent = "Please select an event.";
    isValid = false;
  }

  if (isValid) {
    // All good - show success message
    successMessage.textContent = `Thank you, ${nameInput.value.trim()}! You have registered for the "${eventSelect.options[eventSelect.selectedIndex].text}" event.`;

    // Optionally reset form
    form.reset();
  }
});
