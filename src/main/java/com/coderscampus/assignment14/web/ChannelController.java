package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/channel")
public class ChannelController {
    private final MessageRepository messageRepository;

    public ChannelController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    @GetMapping("/")
    public String getChannelPage() {
        return "channel";  // This should match `channel.html` in the `templates` folder
    }

    @PostMapping("/messages")
    @ResponseBody
    public void sendMessage(@RequestBody Message message) {
        messageRepository.addMessage(message);  // Add message to the repository
    }


    @GetMapping("/messages")
    @ResponseBody
    public List<Message> getMessages() {
        return messageRepository.getAllMessages();  // Return all messages as JSON
    }
}
