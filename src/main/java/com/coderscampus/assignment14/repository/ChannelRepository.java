package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ChannelRepository {
    private Map<Long, Channel> channels = new HashMap<>();

    public void addChannel(Channel channel) {
        channels.put(channel.getId(), channel);
    }

    public Channel getChannel(Long id) {
        return channels.get(id);
    }

    public Map<Long, Channel> getAllChannels() {
        return channels;
    }
}






