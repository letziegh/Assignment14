package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private MessageRepository messageRepository;

    private Long nextChannelId = 2L; // Incremental ID generator for new channels

    public Channel getChannel(Long id) {
        return channelRepository.getChannel(id);
    }
    public Long createChannel(Channel channel) {
        channel.setId(nextChannelId++);
        channelRepository.addChannel(channel);
        return channel.getId();
    }
    public boolean addMessageToChannel(Long channelId, Message message) {
        Channel channel = channelRepository.getChannel(channelId);
        if (channel == null) {
            return false; // Channel does not exist
        }

        message.setChannel(channel);
        messageRepository.addMessage(channelId, message); // Save message to repository
        return true;
    }


    public List<Message> getMessagesForChannel(Long channelId) {
        return messageRepository.getMessages(channelId); // Retrieve messages from repository
    }
    public List<Channel> getAllChannels() {
        return new ArrayList<>(channelRepository.getAllChannels());
    }
}


