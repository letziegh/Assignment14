document.addEventListener("DOMContentLoaded", function () {
    const chatWindow = document.getElementById("chatWindow");
    const messageInput = document.getElementById("message");
    const sendButton = document.getElementById("sendButton");
    const channelId = document.body.dataset.channelId;

    if (!channelId || isNaN(Number(channelId))) {
        console.error("Invalid or missing channel ID:", channelId);
        chatWindow.innerHTML = "<p>Error: Invalid channel ID. Please refresh or contact support.</p>";
        return;
    }
    console.log(`Using channel ID: ${channelId}`);

    function displayMessage(message) {
        const messageElement = document.createElement("div");
        messageElement.textContent = `${message.user.name}: ${message.content}`;
        chatWindow.appendChild(messageElement);
    }

    function loadMessages() {
        fetch(`/channel/${channelId}/messages`)
            .then(response => response.json())
            .then(messages => {
                chatWindow.innerHTML = "";
                messages.forEach(displayMessage);
            })
            .catch(error => console.error("Error loading messages:", error));
    }

    function sendMessage() {
        const content = messageInput.value.trim();
        const username = sessionStorage.getItem("username");

        if (!username) {
            alert("User not logged in. Redirecting to welcome page.");
            window.location.href = "/welcome";
            return;
        }

        if (!content) {
            alert("Message content cannot be empty.");
            return;
        }

        const message = { user: { name: username }, content };



        fetch(`/channel/${channelId}/messages`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(message),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Failed to send message: ${response.statusText}`);
                }
                messageInput.value = ""; // Clear the input field
                loadMessages(); // Refresh messages
            })
            .catch((error) => {
                console.error("Error sending message:", error);
                alert("Failed to send message. Please try again.");
            });
    }


    sendButton.addEventListener("click", sendMessage);
    messageInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter" && !event.shiftKey) {
            event.preventDefault();
            sendMessage();
        }
    });

    loadMessages();
    setInterval(loadMessages, 500);
});
