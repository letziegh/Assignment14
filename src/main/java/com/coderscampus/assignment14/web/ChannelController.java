package com.coderscampus.assignment14.web;


import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String getDefaultChannelPage() {
//        // Redirects to the first available channel
//        return "redirect:/channel/1";
//    }

    @GetMapping("/{channelId}")
    public String getChannelPage(@PathVariable Long channelId, Model model) {
        Channel channel = channelService.getChannel(channelId);
        model.addAttribute("channelId", channelId);
        model.addAttribute("channelName", channel.getName());
        return "channel";
    }

@PostMapping("/{channelId}/messages")
@ResponseBody
public ResponseEntity<?> sendMessage(@PathVariable Long channelId, @RequestBody Message message) {
    if (message.getContent() == null || message.getContent().trim().isEmpty()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message content cannot be empty");
    }
    if (message.getUser() == null || message.getUser().getName() == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User information is missing");
    }

    boolean success = channelService.addMessageToChannel(channelId, message);
    if (!success) {
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().build();
}


    @GetMapping("/{channelId}/messages")
    @ResponseBody
    public List<Message> getMessages(@PathVariable Long channelId) {
        return channelService.getMessagesForChannel(channelId);
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createChannel(@RequestBody Channel channel) {
        if (channel.getName() == null || channel.getName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Channel name cannot be empty");
        }
        Long newChannelId = channelService.createChannel(channel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChannelId);
    }
}

