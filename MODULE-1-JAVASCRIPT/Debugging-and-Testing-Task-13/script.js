const form = document.getElementById("registrationForm");
const messageDiv = document.getElementById("message");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  console.log("Form submission started"); // Log start

  messageDiv.textContent = "Submitting...";
  messageDiv.className = "message";

  // Collect form data
  const formData = {
    name: form.elements["name"].value.trim(),
    email: form.elements["email"].value.trim(),
  };

  console.log("Form data collected:", formData); // Inspect data

  // Set breakpoint here in Chrome DevTools for step-by-step debugging
  debugger;

  // Send POST request to mock API
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  })
    .then((response) => {
      console.log("Response received:", response);
      if (!response.ok) throw new Error("Network response was not ok");
      return response.json();
    })
    .then((data) => {
      console.log("Response JSON data:", data);
      messageDiv.textContent = `Success! Registered user ID: ${data.id}`;
      messageDiv.className = "message success";
      form.reset();
    })
    .catch((error) => {
      console.error("Error occurred:", error);
      messageDiv.textContent = `Error: ${error.message}`;
      messageDiv.className = "message error";
    });
});
