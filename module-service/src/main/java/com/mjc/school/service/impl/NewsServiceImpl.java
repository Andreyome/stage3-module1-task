package com.mjc.school.service.impl;

import com.mjc.school.service.Validator.ValidatorImpl;
import com.mjc.school.repository.Repository;
import com.mjc.school.repository.impl.RepositoryImpl;
import com.mjc.school.repository.models.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.Mapping.Mapper;
import com.mjc.school.service.NotFoundException;
import com.mjc.school.service.Service;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements Service<NewsDto> {
    private final Repository<NewsModel> newsRepository;
    private final ValidatorImpl newsValidator;
    private static NewsServiceImpl INSTANCE;
    public static NewsServiceImpl getInstance(){
        if (INSTANCE== null){
            INSTANCE=new NewsServiceImpl();
        }
        return INSTANCE;
    }

    public NewsServiceImpl() {
        this.newsRepository = new RepositoryImpl();
        this.newsValidator = new ValidatorImpl();
    }

    @Override
    public List<NewsDto> readAll() {
        List<NewsModel> list = newsRepository.readAll();
        List<NewsDto> result = new ArrayList<>();
        list.forEach(i -> result.add(Mapper.INSTANCE.newsToDto(i)));
        return result;
    }

    @Override
    public NewsDto create(NewsDto newsDTO) {
        newsValidator.validateNews(newsDTO);
        NewsModel news = newsRepository.create(Mapper.INSTANCE.newsDtoToModelCreate(newsDTO));
        return Mapper.INSTANCE.newsToDto(news);
    }

    @Override
    public NewsDto readById(Long id) {
        if (id > newsRepository.readAll().size()) {
            throw new RuntimeException("No such news with provided id.");
        }
        return Mapper.INSTANCE.newsToDto(newsRepository.readById(id));
    }

    @Override
    public NewsDto updateNews(NewsDto updatedNews) {
        newsValidator.validateNews(updatedNews);
        return Mapper.INSTANCE.newsToDto(newsRepository.updateNews(Mapper.INSTANCE.newsDtoToModel(updatedNews)));
    }

    @Override
    public Boolean deleteNewsById(Long id) {
        if (!newsRepository.deleteNewsById(id)) {
            throw new NotFoundException("No such news with provided id.");
        }
        return true;
    }
}
