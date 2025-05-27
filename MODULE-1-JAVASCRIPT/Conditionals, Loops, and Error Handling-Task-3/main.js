// Sample list of events
const events = [
  { name: "Cleanup Drive", date: "2025-06-20", seats: 10 },
  { name: "Tree Plantation", date: "2024-12-01", seats: 0 },
  { name: "Art Workshop", date: "2025-07-10", seats: 5 },
  { name: "Old Book Fair", date: "2023-11-05", seats: 15 }
];

// Get today's date in YYYY-MM-DD format
const today = new Date().toISOString().split("T")[0];

console.log("Filtering and displaying valid events:\n");

// Loop through events and show only valid (upcoming & with seats) events
events.forEach(event => {
  if (event.date > today && event.seats > 0) {
    console.log(`Event: ${event.name}\nDate: ${event.date}\nSeats Available: ${event.seats}\n`);

    // Try to register user for event
    try {
      registerUser(event);
    } catch (error) {
      console.error(`Registration failed for ${event.name}: ${error.message}`);
    }

  } else {
    console.log(`Skipping event "${event.name}" (either past or full).\n`);
  }
});

// Registration function with error handling
function registerUser(event) {
  if (event.seats <= 0) {
    throw new Error("No seats available");
  }

  // Simulate registration
  event.seats--;
  console.log(`✅ Registered for ${event.name}. Remaining Seats: ${event.seats}\n`);
}
