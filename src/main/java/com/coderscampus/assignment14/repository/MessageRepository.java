package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();

    public synchronized void addMessage(Message message) {
        messages.add(message);
    }

    public synchronized List<Message> getAllMessages() {
        return new ArrayList<>(messages);
    }
}






