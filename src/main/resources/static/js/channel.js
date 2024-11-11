

document.addEventListener("DOMContentLoaded", function () {
    const chatWindow = document.getElementById("chatWindow");
    const messageInput = document.getElementById("message");
    const username = sessionStorage.getItem('username');

    if (!username) {
        alert("Please enter your name on the welcome page first.");
        window.location.href = "/";
        return;
    }

    // Function to display a message in the chat window
    function displayMessage(message) {
        const messageElement = document.createElement("div");
        messageElement.textContent = `${message.user.name}: ${message.content}`;
        chatWindow.appendChild(messageElement);
    }

    // Function to load messages from the server
    function loadMessages() {
        fetch("/channel/messages")
            .then(response => response.json())
            .then(messages => {
                chatWindow.innerHTML = "";  // Clear chat window before appending messages
                messages.forEach(displayMessage);  // Display each message
            })
            .catch(error => console.error("Error loading messages:", error));
    }

    // Poll for messages every 3 seconds
    setInterval(loadMessages, 3000);

    // Function to send a message
    function sendMessage() {
        const content = messageInput.value.trim();
        if (content === "") return;

        // const message = { user: username, content: content };
        const message = { user: { name: username }, content: content };
        fetch("/channel/messages", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(message)
        })
            .then(() => {
                messageInput.value = "";  // Clear the input field after sending
                loadMessages();  // Immediately load messages after sending
            })
            .catch(error => console.error("Error sending message:", error));
    }

    // Attach sendMessage to button click
    document.getElementById("sendButton").addEventListener("click", sendMessage);
});



