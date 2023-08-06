package com.mjc.school.service.DTO;

public class AuthorDTO {
    private long authorId;
    private String authorName;
    public AuthorDTO(long id,String name){
        this.authorId = id;
        this.authorName = name;
    }


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
