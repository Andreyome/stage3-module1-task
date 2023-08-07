package com.mjc.school.service.impl;

import Validator.ValidatorImpl;
import com.mjc.school.repository.impl.RepositoryImpl;
import com.mjc.school.repository.models.NewsModel;
import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.Mapping.Mapper;
import com.mjc.school.service.NotFoundException;
import com.mjc.school.service.Service;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements Service<NewsDTO> {
    private final RepositoryImpl newsRepository;
    private final ValidatorImpl newsValidator;

    public NewsServiceImpl(){
        this.newsRepository = new RepositoryImpl();
        this.newsValidator = new ValidatorImpl();
    }

    @Override
    public List<NewsDTO> readAll() {
        List<NewsModel> list= newsRepository.readAll();
        List<NewsDTO> result = new ArrayList<>();
        list.forEach(i->result.add(Mapper.INSTANCE.newsToDto(i)));
        return result;
    }

    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        newsValidator.validateNews(newsDTO);
        NewsModel news = newsRepository.create(Mapper.INSTANCE.newsDtoToModel(newsDTO));
        return Mapper.INSTANCE.newsToDto(news);
    }

    @Override
    public NewsDTO readById(Long id) {
        if(id> newsRepository.readAll().size()){
            throw new RuntimeException("No such news with provided id.");
        }
        return Mapper.INSTANCE.newsToDto(newsRepository.readById(id));
    }

    @Override
    public NewsDTO updateNews(NewsDTO updatedNews) {
        newsValidator.validateNews(updatedNews);
        return Mapper.INSTANCE.newsToDto(newsRepository.updateNews(Mapper.INSTANCE.newsDtoToModel(updatedNews)));
    }

    @Override
    public Boolean deleteNewsById(Long id) {
         if(!newsRepository.deleteNewsById(id)){
             throw new NotFoundException("No such news with provided id.");
         }
         return true;
    }
}
