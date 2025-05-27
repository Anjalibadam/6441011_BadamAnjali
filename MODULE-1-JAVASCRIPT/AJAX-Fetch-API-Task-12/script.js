const form = document.getElementById("registrationForm");
const messageDiv = document.getElementById("message");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  messageDiv.textContent = "Submitting...";
  messageDiv.className = "message";

  const formData = {
    name: form.elements["name"].value.trim(),
    email: form.elements["email"].value.trim(),
  };

  // Simulate delayed fetch POST using setTimeout
  // Mock API: https://jsonplaceholder.typicode.com/posts (fake POST endpoint)
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => {
        if (!response.ok) throw new Error("Network response was not ok");
        return response.json();
      })
      .then((data) => {
        messageDiv.textContent = `Success! Registered user ID: ${data.id}`;
        messageDiv.className = "message success";
        form.reset();
      })
      .catch((error) => {
        messageDiv.textContent = `Error: ${error.message}`;
        messageDiv.className = "message error";
      });
  }, 2000); // 2-second delay to simulate server response
});
