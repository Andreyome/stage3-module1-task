package com.mjc.school.repository;

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
        }
        return newNews;
    }

    @Override
    public NewsModel getNewsById(long id) {
        return dataSource.getAllNews().stream().filter(eachNew ->eachNew.getId()==id).findFirst().orElseThrow();
    }

    @Override
    public NewsModel updateNews(NewsModel updatedNews) {
        NewsModel changed = getNewsById(updatedNews.getId());
        changed.setContent(updatedNews.getContent());
        changed.setTitle(updatedNews.getTitle());
        changed.setAuthorId(updatedNews.getAuthorId());
        changed.setLastUpdateTime(LocalDateTime.now());
        return changed;
    }

    @Override
    public Boolean deleteNewsById(long id) {
        return dataSource.getAllNews().remove(getNewsById(id));
    }
}
