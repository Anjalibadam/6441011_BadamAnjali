const events = [
  { name: "Jazz Night", category: "Music", seats: 5 },
  { name: "Painting Class", category: "Art", seats: 2 },
  { name: "Tech Talk", category: "Tech", seats: 4 },
  { name: "Guitar Workshop", category: "Music", seats: 0 },
];

let filteredEvents = [...events]; // default: show all

const container = document.getElementById("eventContainer");
const categoryFilter = document.getElementById("categoryFilter");
const searchInput = document.getElementById("searchInput");

// Render events
function renderEvents() {
  container.innerHTML = "";

  filteredEvents.forEach((event, index) => {
    const card = document.createElement("div");
    card.className = "event-card";

    card.innerHTML = `
      <h2>${event.name}</h2>
      <p>Category: ${event.category}</p>
      <p>Seats Available: ${event.seats}</p>
    `;

    const registerBtn = document.createElement("button");
    registerBtn.textContent = "Register";
    registerBtn.disabled = event.seats === 0;

    // onclick event
    registerBtn.onclick = () => {
      if (event.seats > 0) {
        event.seats--;
        renderEvents(); // Refresh UI
      }
    };

    card.appendChild(registerBtn);
    container.appendChild(card);
  });
}

// onchange event for category filtering
categoryFilter.onchange = function () {
  const selected = this.value;
  filteredEvents = selected === "All"
    ? [...events]
    : events.filter(e => e.category === selected);
  renderEvents();
};

// keydown event for search
searchInput.addEventListener("keydown", function (e) {
  if (e.key === "Enter") {
    const keyword = this.value.toLowerCase();
    filteredEvents = events.filter(event =>
      event.name.toLowerCase().includes(keyword)
    );
    renderEvents();
  }
});

// Initial render
renderEvents();
