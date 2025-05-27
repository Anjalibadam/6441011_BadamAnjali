// Sample event data
const events = [
  { name: "Music Concert", date: "2025-07-10", seats: 5 },
  { name: "Art Workshop", date: "2025-08-15", seats: 3 },
  { name: "Tech Talk", date: "2025-09-05", seats: 0 }
];

// Access DOM container
const container = document.querySelector("#event-container");

// Render events
function renderEvents() {
  container.innerHTML = ""; // Clear previous
  events.forEach((event, index) => {
    const card = document.createElement("div");
    card.className = "event-card";

    const title = document.createElement("h2");
    title.textContent = event.name;

    const date = document.createElement("p");
    date.textContent = `📅 Date: ${event.date}`;

    const seats = document.createElement("p");
    seats.textContent = `🪑 Seats Available: ${event.seats}`;

    const registerBtn = document.createElement("button");
    registerBtn.textContent = "Register";
    registerBtn.disabled = event.seats === 0;

    const cancelBtn = document.createElement("button");
    cancelBtn.textContent = "Cancel";
    cancelBtn.disabled = event.seats >= 5;

    // Register event
    registerBtn.addEventListener("click", () => {
      if (event.seats > 0) {
        event.seats--;
        renderEvents(); // Refresh UI
      }
    });

    // Cancel event
    cancelBtn.addEventListener("click", () => {
      if (event.seats < 5) {
        event.seats++;
        renderEvents(); // Refresh UI
      }
    });

    card.appendChild(title);
    card.appendChild(date);
    card.appendChild(seats);
    card.appendChild(registerBtn);
    card.appendChild(cancelBtn);

    container.appendChild(card);
  });
}

// Initial render
renderEvents();
