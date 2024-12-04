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
        private final Map<Long, List<Message>> channelMessages = new HashMap<>();

        public synchronized void addMessage(Long channelId, Message message) {
            channelMessages.computeIfAbsent(channelId, k -> new ArrayList<>()).add(message);
        }

        public synchronized List<Message> getMessages(Long channelId) {
            return channelMessages.getOrDefault(channelId, new ArrayList<>());
        }
    }








