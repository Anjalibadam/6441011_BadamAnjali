// Global event list
let events = [];

// 🔧 1. Function to add events
function addEvent(name, date, seats, category) {
  events.push({ name, date, seats, category });
}

// 🔁 2. Closure to track total registrations by category
function createCategoryCounter() {
  const counts = {};
  return function (category) {
    counts[category] = (counts[category] || 0) + 1;
    console.log(`🔁 Total registrations in "${category}": ${counts[category]}`);
  };
}
const registerCounter = createCategoryCounter();

// 🔧 3. Function to register a user for an event
function registerUser(eventName) {
  const event = events.find(e => e.name === eventName);
  if (!event) {
    console.log(`❌ Event "${eventName}" not found.`);
    return;
  }

  if (event.seats > 0) {
    event.seats--;
    console.log(`✅ Registered for ${event.name}. Seats left: ${event.seats}`);
    // Correct usage: Call closure with category
    registerCounter(event.category);
  } else {
    console.log(`❌ No seats left for ${event.name}.`);
  }
}

// 🔧 4. Function to filter events by category and custom callback
function filterEventsByCategory(category, filterCallback) {
  const filtered = events.filter(event => event.category === category);
  return filtered.filter(filterCallback);
}

// 🎬 Add some sample events
addEvent("Tree Plantation", "2025-07-01", 10, "Environment");
addEvent("Book Fair", "2025-07-05", 5, "Education");
addEvent("Hackathon", "2025-07-10", 0, "Tech");
addEvent("Yoga Workshop", "2025-06-15", 8, "Health");

// 📅 Today's date for filtering
const today = new Date().toISOString().split("T")[0];

// 🔍 Filter & display upcoming Education events with available seats
console.log("\n📚 Upcoming Education Events:");
const upcomingEducationEvents = filterEventsByCategory("Education", event => {
  return event.date > today && event.seats > 0;
});
upcomingEducationEvents.forEach(e => {
  console.log(`- ${e.name} (${e.date}) | Seats: ${e.seats}`);
});

// 🎟️ Simulate user registrations
console.log("\n🎟️ Simulating Registrations:");
registerUser("Book Fair");
registerUser("Tree Plantation");
registerUser("Book Fair");
registerUser("Hackathon"); // full
registerUser("Unknown Event"); // invalid


