const apiURL = "https://jsonplaceholder.typicode.com/posts"; // Mock API
const spinner = document.getElementById("spinner");
const eventsDiv = document.getElementById("events");

// Render events
function displayEvents(events) {
  eventsDiv.innerHTML = "";
  events.slice(0, 5).forEach((event) => {
    const div = document.createElement("div");
    div.className = "event";
    div.innerHTML = `<strong>${event.title}</strong><p>${event.body}</p>`;
    eventsDiv.appendChild(div);
  });
}

// Using Promises with .then()/.catch()
function fetchWithThen() {
  spinner.style.display = "block";
  eventsDiv.innerHTML = "";

  fetch(apiURL)
    .then((response) => {
      if (!response.ok) throw new Error("Network response was not ok");
      return response.json();
    })
    .then((data) => {
      displayEvents(data);
    })
    .catch((error) => {
      eventsDiv.innerHTML = `<p style="color: red;">Error: ${error.message}</p>`;
    })
    .finally(() => {
      spinner.style.display = "none";
    });
}

// Using async/await
async function fetchWithAsync() {
  spinner.style.display = "block";
  eventsDiv.innerHTML = "";

  try {
    const response = await fetch(apiURL);
    if (!response.ok) throw new Error("Network error");
    const data = await response.json();
    displayEvents(data);
  } catch (error) {
    eventsDiv.innerHTML = `<p style="color: red;">Error: ${error.message}</p>`;
  } finally {
    spinner.style.display = "none";
  }
}
