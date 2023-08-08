package com.mjc.school.service.Validator;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.service.dto.NewsDto;

import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl {
    private final String AUTHOR_ERROR = "Author with provided id not existing.";
    private final String TITLE_ERROR = "Title length should be between 5-30 length.";
    private final String CONTENT_ERROR = "News content should be between 5-255 length.";
    private final DataSource dataSource;
    List<AuthorModel> authorModel;
    List <Long> authorIds;

    public ValidatorImpl(){
        dataSource = DataSource.getInstance();
        authorModel = dataSource.getAllAuthors();
        authorIds =new ArrayList<>();
        for (AuthorModel tmp:authorModel){
            this.authorIds.add(tmp.getId());
        }
    }
    public void validateNews(NewsDto newsDTO){
        Long authorId= newsDTO.getAuthorId();
        String title = newsDTO.getTitle();
        String content = newsDTO.getContent();
        if(!authorIds.contains(authorId)) {
            throw new ValidationException(AUTHOR_ERROR);
        }
        if(title.length()>30||title.length()<5){
            throw new ValidationException(TITLE_ERROR);
        }
        if (content.length()>255||content.length()<5){
            throw new ValidationException(CONTENT_ERROR);
        }
    }
}
