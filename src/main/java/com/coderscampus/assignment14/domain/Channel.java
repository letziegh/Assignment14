package com.coderscampus.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private Long id;
    private List<Messages> messages = new ArrayList<>();

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

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
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