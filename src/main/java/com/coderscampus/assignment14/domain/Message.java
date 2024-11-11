package com.coderscampus.assignment14.domain;

public class Message {
    private String content;
    private Long id;
    private Long userId;
    private Channel channel;
    private User user;

    public Message() {

    }
    public Message(User user, String content) {
        this.user = user;
        this.content = content;
    }
    public Message(String content, Long id, Long userId, Channel channel, User user) {
        this.content = content;
        this.id = id;
        this.userId = userId;
        this.channel = channel;
        this.user = user;
    }



    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                ", channel=" + channel +
                ", user=" + user +
                '}';
    }
}
