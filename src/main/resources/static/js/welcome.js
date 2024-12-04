document.addEventListener("DOMContentLoaded", function () {
    const userNameDisplay = document.getElementById("userNameDisplay");
    const channelList = document.getElementById("channelList");
    const refreshChannelsButton = document.getElementById("refreshChannelsButton");
    const createChannelButton= document.getElementById("createChannelButton");
    const newChannelNameInput = document.getElementById("newChannelName");

    const username = sessionStorage.getItem("username");
    if (!username) {
        const enteredName = prompt("Please enter your name:");
        if (enteredName && enteredName.trim()) {
            sessionStorage.setItem("username", enteredName.trim());
        } else {
            alert("Name is required to join the chat.");
            window.location.reload();
        }
    }

    userNameDisplay.textContent = sessionStorage.getItem("username");

    function createChannel() {
        //   document.getElementById("createChannelButton").addEventListener("click", () => {
        //  const newChannelNameInput = document.getElementById("newChannelName");
        const newChannelName = newChannelNameInput.value.trim();

        if (!newChannelName) {
            alert("Channel name cannot be empty.");
            return;
        }

        fetch("/channel/create", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({name: newChannelName}),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to create channel.");
                }
                return response.json();
            })
            .then(() => {
                alert("Channel created successfully.");
                newChannelNameInput.value = "";
                window.location.reload(); // Reload the channel list
            })
            .catch((error) => {
                console.error("Error creating channel:", error);
            });
    }

    createChannelButton.addEventListener("click", createChannel);


    newChannelNameInput.addEventListener("keydown", function (event) {
        if (event.key === "Enter"&& !event.shiftKey) {
            event.preventDefault();
            createChannel();
        }

    });

    function loadChannels() {
        fetch("/channel/all")
            .then(response => response.json())
            .then(channels => {
                channelList.innerHTML = ""; // Clear the list
                channels.forEach(channel => {
                    const channelItem = document.createElement("li");
                    const joinButton = document.createElement("button");
                    joinButton.textContent = `Join ${channel.name}`;
                    joinButton.addEventListener("click", () => {
                        window.location.href = `/channel/${channel.id}`;
                    });
                    channelItem.appendChild(joinButton);
                    channelList.appendChild(channelItem);
                });
            })
            .catch(error => console.error("Error loading channels:", error));
    }

    refreshChannelsButton.addEventListener("click", loadChannels);

    loadChannels();
});

