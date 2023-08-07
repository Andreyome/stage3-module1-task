package com.mjc.school.controller.impl;

import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.impl.NewsServiceImpl;
import com.mjc.school.controller.Controller;

import java.util.List;

public class ControllerImpl implements Controller<NewsDTO> {
    NewsServiceImpl service;
    public ControllerImpl(){
        this.service= new NewsServiceImpl();
    }

    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        return service.create(newsDTO);
    }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        return service.updateNews(newsDTO);
    }

    @Override
    public NewsDTO read(long id) {
        return service.readById(id);
    }

    @Override
    public Boolean delete(long id) {
        return service.deleteNewsById(id);
    }

    @Override
    public List<NewsDTO> readAll() {
        return service.readAll();
    }
}
