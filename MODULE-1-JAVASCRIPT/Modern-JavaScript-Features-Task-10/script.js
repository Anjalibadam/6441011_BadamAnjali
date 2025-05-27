const apiURL = "https://jsonplaceholder.typicode.com/posts";
const spinner = document.getElementById("spinner");
const eventsDiv = document.getElementById("events");

// Function with default parameters and destructuring
const createEventHTML = ({ title = "No Title", body = "No Description" } = {}) => `
  <div class="event">
    <strong>${title}</strong>
    <p>${body}</p>
  </div>
`;

// Clone and filter event list using spread operator
const filterEvents = (events, keyword = "") => {
  const clonedEvents = [...events]; // clone the list
  if (!keyword) return clonedEvents;
  return clonedEvents.filter(({ title, body }) =>
    title.toLowerCase().includes(keyword.toLowerCase()) ||
    body.toLowerCase().includes(keyword.toLowerCase())
  );
};

async function fetchAndDisplayEvents(keyword = "") {
  spinner.style.display = "block";
  eventsDiv.innerHTML = "";

  try {
    const response = await fetch(apiURL);
    if (!response.ok) throw new Error("Network error");

    let events = await response.json();

    // Filter events if keyword provided
    events = filterEvents(events, keyword);

    // Only display first 5 events for brevity
    const html = events.slice(0, 5).map(createEventHTML).join("");
    eventsDiv.innerHTML = html || "<p>No events found.</p>";
  } catch (error) {
    eventsDiv.innerHTML = `<p style="color: red;">Error: ${error.message}</p>`;
  } finally {
    spinner.style.display = "none";
  }
}
