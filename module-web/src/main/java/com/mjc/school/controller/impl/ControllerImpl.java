package com.mjc.school.controller.impl;

import com.mjc.school.service.dto.NewsDtoObject;
import com.mjc.school.service.Service;
import com.mjc.school.service.impl.NewsServiceImpl;
import com.mjc.school.controller.Controller;

import java.util.List;

public class ControllerImpl implements Controller<NewsDtoObject> {
    private final Service<NewsDtoObject> newsService;

    public ControllerImpl() {
        this.newsService = NewsServiceImpl.getInstance();
    }

    @Override
    public NewsDtoObject create(NewsDtoObject newsDto) {
        return newsService.create(newsDto);
    }

    @Override
    public NewsDtoObject update(NewsDtoObject newsDto) {
        return newsService.updateNews(newsDto);
    }

    @Override
    public NewsDtoObject readBy(Long id) {
        return newsService.readById(id);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.deleteNewsById(id);
    }

    @Override
    public List<NewsDtoObject> readAll() {
        return newsService.readAll();
    }
}
