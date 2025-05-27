// 🎯 1. Create array to hold all events
let communityEvents = [];

// 🎯 2. Add events using .push()
communityEvents.push(
  { name: "Guitar Night", category: "Music" },
  { name: "Art Exhibition", category: "Art" },
  { name: "Jazz Festival", category: "Music" },
  { name: "Tech Meetup", category: "Technology" },
  { name: "Choir Practice", category: "Music" }
);

// 🎯 3. Use .filter() to get only music events
const musicEvents = communityEvents.filter(event => event.category === "Music");

// 🎯 4. Use .map() to format each event into HTML
const formattedCards = musicEvents.map(event => {
  return `
    <div class="event-card">
      <h2>${event.name}</h2>
      <p>Category: ${event.category}</p>
    </div>
  `;
});

// 🎯 5. Display the event cards on the page
document.getElementById("music-events").innerHTML = formattedCards.join('');
