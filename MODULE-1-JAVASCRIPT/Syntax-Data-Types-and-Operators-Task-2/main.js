// Store event details using appropriate data types
const eventName = "Community Cleanup Drive";
const eventDate = "2025-06-15";
let availableSeats = 50;

// Display event info using template literals
const eventInfo = `Event: ${eventName}\nDate: ${eventDate}\nAvailable Seats: ${availableSeats}`;
console.log(eventInfo);

// Alert when the page is fully loaded
window.onload = function () {
  alert("Page is fully loaded. Event info is logged in the console.");
};

// Simulate a user registering
availableSeats--;
console.log(`Seats left after one registration: ${availableSeats}`);

// Simulate a user canceling
availableSeats++;
console.log(`Seats available after cancellation: ${availableSeats}`);
