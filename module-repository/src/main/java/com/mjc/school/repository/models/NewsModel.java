package com.mjc.school.repository.models;

import java.time.LocalDateTime;

public class NewsModel {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private long authorId;
    public NewsModel(long id,String title, String content, LocalDateTime createTime, LocalDateTime lastUpdateTime,long authorId){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
