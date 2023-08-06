package com.mjc.school.service.DTO;

public class NewsDTO {
    private long id;
    private String title;
    private String content;
    private long authorId;

    public NewsDTO(long id, String title, String content, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }

    public NewsDTO() {
    }

    public NewsDTO(String title, String content, long authorId) {
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
}
