$(document).ready(function() {
  // Show events with fadeIn on button click
  $('#registerBtn').click(function() {
    $('.event-card').fadeIn(600);
  });

  // Hide events with fadeOut on button click
  $('#hideBtn').click(function() {
    $('.event-card').fadeOut(600);
  });
});
