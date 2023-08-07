package com.mjc.school.controller.impl;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.Service;
import com.mjc.school.service.impl.NewsServiceImpl;
import com.mjc.school.controller.Controller;

import java.util.List;

public class ControllerImpl implements Controller<NewsDto> {
    private final Service<NewsDto> service;
    public ControllerImpl(){
        this.service= new NewsServiceImpl();
    }

    @Override
    public NewsDto create(NewsDto newsDTO) {
        return service.create(newsDTO);
    }

    @Override
    public NewsDto update(NewsDto newsDTO) {
        return service.updateNews(newsDTO);
    }

    @Override
    public NewsDto readBy(Long id) {
        return service.readById(id);
    }

    @Override
    public Boolean delete(Long id) {
        return service.deleteNewsById(id);
    }

    @Override
    public List<NewsDto> readAll() {
        return service.readAll();
    }
}
