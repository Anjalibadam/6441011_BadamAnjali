// 🔧 Event Constructor Function
function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}

// 🧠 Add checkAvailability() to prototype
Event.prototype.checkAvailability = function () {
  const today = new Date().toISOString().split("T")[0];
  return this.date > today && this.seats > 0;
};

// 🎬 Create some events
const event1 = new Event("Art Workshop", "2025-07-10", 12, "Creativity");
const event2 = new Event("Coding Bootcamp", "2024-05-01", 0, "Education");
const event3 = new Event("Community Yoga", "2025-08-15", 20, "Health");

const events = [event1, event2, event3];

// 🎯 Display in HTML
const eventList = document.getElementById("event-list");

events.forEach(event => {
  const container = document.createElement("div");
  container.style.marginBottom = "1em";

  const available = event.checkAvailability() ? "✅ Available" : "❌ Not Available";

  const details = Object.entries(event)
    .map(([key, value]) => `<strong>${key}</strong>: ${value}`)
    .join("<br>");

  container.innerHTML = `<h3>${event.name}</h3>
                         ${details}<br>
                         <strong>Status:</strong> ${available}`;

  eventList.appendChild(container);
});
