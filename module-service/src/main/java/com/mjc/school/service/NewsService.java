package com.mjc.school.service;

import Validator.Validator;
import com.mjc.school.repository.RepositoryImpl;
import com.mjc.school.repository.models.NewsModel;
import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.Mapping.Mapper;

import java.util.ArrayList;
import java.util.List;

public class NewsService implements Service<NewsDTO> {
    private final RepositoryImpl repository;
    Validator validator = new Validator();
    public NewsService(){
        this.repository = new RepositoryImpl();
    }

    @Override
    public List<NewsDTO> readAll() {
        List<NewsModel> list= repository.readAll();
        List<NewsDTO> result = new ArrayList<>();
        list.forEach(i->result.add(Mapper.INSTANCE.newsToDto(i)));
        return result;
    }

    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        validator.validateNews(newsDTO);
        NewsModel news = repository.create(Mapper.INSTANCE.newsDtoToModel(newsDTO));
        return Mapper.INSTANCE.newsToDto(news);
    }

    @Override
    public NewsDTO getNewsById(long id) {
        NewsModel news = repository.getNewsById(id);
        if (news == null){
            throw new NotFoundException("No such news with provided id.");
        }
        return Mapper.INSTANCE.newsToDto(repository.getNewsById(id));
    }

    @Override
    public NewsDTO updateNews(NewsDTO updatedNews) {
        validator.validateNews(updatedNews);
        return Mapper.INSTANCE.newsToDto(repository.updateNews(Mapper.INSTANCE.newsDtoToModel(updatedNews)));
    }

    @Override
    public Boolean deleteNewsById(long id) {
         if(!repository.deleteNewsById(id)){
             throw new NotFoundException("No such news with provided id.");
         }
         return true;
    }
}
