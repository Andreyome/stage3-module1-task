package com.mjc.school.service.impl;

import Validator.Validator;
import com.mjc.school.repository.impl.RepositoryImpl;
import com.mjc.school.repository.models.NewsModel;
import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.Mapping.Mapper;
import com.mjc.school.service.NotFoundException;
import com.mjc.school.service.Service;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements Service<NewsDTO> {
    private final RepositoryImpl repository;
    Validator validator;
    public NewsServiceImpl(){
        this.repository = new RepositoryImpl();
        this.validator = new Validator();
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
    public NewsDTO getNewsById(Long id) {
        if(id>repository.readAll().size()){
            throw new RuntimeException("No such news with provided id.");
        }
        return Mapper.INSTANCE.newsToDto(repository.readById(id));
    }

    @Override
    public NewsDTO updateNews(NewsDTO updatedNews) {
        validator.validateNews(updatedNews);
        return Mapper.INSTANCE.newsToDto(repository.updateNews(Mapper.INSTANCE.newsDtoToModel(updatedNews)));
    }

    @Override
    public Boolean deleteNewsById(Long id) {
         if(!repository.deleteNewsById(id)){
             throw new NotFoundException("No such news with provided id.");
         }
         return true;
    }
}