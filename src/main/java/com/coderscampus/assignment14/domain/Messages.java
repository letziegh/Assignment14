package com.coderscampus.assignment14.domain;

public class Messages {
    private String content;
    private Long id;
    private Long userId;

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
        return "Messages{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }
}
