package com.coderscampus.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private Long id;
    private List<Message> messages = new ArrayList<>();

    public Channel (String name, Long id){
        this.name = name;
        this.id = id;
        this.messages = messages;

    }
    public void addMessage(Message message) {
        this.messages.add(message);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", messages=" + messages +
                '}';
    }
}