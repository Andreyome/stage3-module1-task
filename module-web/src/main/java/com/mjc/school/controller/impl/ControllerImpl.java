package com.mjc.school.controller.impl;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.Service;
import com.mjc.school.service.impl.NewsServiceImpl;
import com.mjc.school.controller.Controller;

import java.util.List;

public class ControllerImpl implements Controller<NewsDto> {
    private final Service<NewsDto> newsService;

    public ControllerImpl() {
        this.newsService = NewsServiceImpl.getInstance();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return newsService.updateNews(newsDto);
    }

    @Override
    public NewsDto readBy(Long id) {
        return newsService.readById(id);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.deleteNewsById(id);
    }

    @Override
    public List<NewsDto> readAll() {
        return newsService.readAll();
    }
}
