package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {
    private final ChannelRepository channelRepository;
    private final MessageRepository messageRepository;

    private Long nextChannelId = 2L;

    public ChannelService(ChannelRepository channelRepository, MessageRepository messageRepository) {
        this.channelRepository = channelRepository;
        this.messageRepository = messageRepository;
    }

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
            return false;
        }

        message.setChannel(channel);
        messageRepository.addMessage(channelId, message);
        return true;
    }


    public List<Message> getMessagesForChannel(Long channelId) {
        return messageRepository.getMessages(channelId);
    }
    public List<Channel> getAllChannels() {
        return new ArrayList<>(channelRepository.getAllChannels());
    }
}


