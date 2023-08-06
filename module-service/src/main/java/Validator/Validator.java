package Validator;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.RepositoryImpl;
import com.mjc.school.repository.data.AuthorData;
import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.service.DTO.AuthorDTO;
import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.Mapping.Mapper;

import java.util.List;

public class Validator {
    private final String AUTHOR_ERROR = "Author with provided id not existing.";
    private final String TITLE_ERROR = "Title length should be between 5-30 length.";
    private final String CONTENT_ERROR = "News content should be between 5-255 length.";
    private final DataSource dataSource;
    List<AuthorModel> authorModel;
    List <Long> authorIds;

    public Validator(){
        dataSource = DataSource.getInstance();
        authorModel = dataSource.getAllAuthors();
        for (AuthorModel tmp:authorModel){
            authorIds.add(tmp.getId());
        }
    }
    public void validateNews(NewsDTO newsDTO){
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
