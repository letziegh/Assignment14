package com.coderscampus.assignment14.repository;

import com.coderscampus.assignment14.domain.Channel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChannelRepository {
    private Map<Long, Channel> channels = new HashMap<>();

    public void addChannel(Channel channel) {

        channels.put(channel.getId(), channel);
    }

    public Channel getChannel(Long id) {

        return channels.get(id);
    }

    public Collection<Channel> getAllChannels() {

        return channels.values();
    }

    @PostConstruct
    public void init() {
        addChannel(new Channel("General", 1L));
    }
}









