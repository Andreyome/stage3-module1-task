package com.mjc.school.repository.impl;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.Repository;
import com.mjc.school.repository.models.NewsModel;

import java.time.LocalDateTime;
import java.util.List;

public class RepositoryImpl implements Repository<NewsModel> {
    private DataSource dataSource;

    public RepositoryImpl() {
        dataSource = DataSource.getInstance();
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    @Override
    public NewsModel create(NewsModel newNews) {
        List<NewsModel> news = dataSource.getAllNews();
        if(news.size()>0){
            newNews.setId(news.size()+1);
            dataSource.getAllNews().add(newNews);
        }
        return newNews;
    }

    @Override
    public NewsModel getNewsById(Long id) {
        return dataSource.getAllNews().stream().filter(eachNew ->eachNew.getId()==id).findFirst().orElseThrow();
    }

    @Override
    public NewsModel updateNews(NewsModel updatedNews) {
        dataSource.getAllNews().remove(getNewsById(updatedNews.getId()));
        dataSource.getAllNews().add(updatedNews);
        return updatedNews;
    }

    @Override
    public Boolean deleteNewsById(Long id) {
        return dataSource.getAllNews().remove(getNewsById(id));
    }
}
