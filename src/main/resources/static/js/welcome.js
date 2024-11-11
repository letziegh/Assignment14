
document.addEventListener("DOMContentLoaded", function () {
    // Check if user's name is already stored in sessionStorage
    if (!sessionStorage.getItem('username')) {
        let username = prompt("Please enter your name:");
        if (username && username.trim()) {
            sessionStorage.setItem('username', username);
        } else {
            alert("Name is required to join the chat.");
            window.location.reload();  // Reload if name is not entered
        }
    }

    const joinChannelButton = document.getElementById("joinChannelButton");

    // Display the username and enable the "Join Channel" button
    const userNameDisplay = document.getElementById("userNameDisplay");
    userNameDisplay.textContent = sessionStorage.getItem('username');
    joinChannelButton.style.display = "inline";

    // Redirect to `/channel` on button click
    joinChannelButton.addEventListener("click", function() {
        window.location.href = "/channel/";
    });
});






