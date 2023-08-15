package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public class NewsDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private long authorId;

    public NewsDto(long id, String title, String content, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
    public NewsDto( String title, String content, LocalDateTime crTime, LocalDateTime lastUpTime, long authorId) {
        this.title = title;
        this.content = content;
        this.createTime = crTime;
        this.lastUpdateTime = lastUpTime;
        this.authorId = authorId;
    }

    public NewsDto() {
    }

    public NewsDto(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
    @Override
    public String toString(){
        return "News id: "+id+"News title: "+title+"News content: "+content+"News author id: "+authorId+ "Create time: "+ createTime+"Last change time: "+lastUpdateTime;
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
}
