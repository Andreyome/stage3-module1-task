package com.mjc.school.repository;

import com.mjc.school.repository.data.AuthorData;
import com.mjc.school.repository.data.NewsData;
import com.mjc.school.repository.models.AuthorModel;
import com.mjc.school.repository.models.NewsModel;

import java.util.List;

public class DataSource {
    private static DataSource Instance;
    List<AuthorModel> authors;
    List<NewsModel> news;
    public DataSource(){
        authors = AuthorData.getInstance().getAuthors();
        news = NewsData.getInstance().getNews();
    }

    public static DataSource getInstance() {
        if (Instance == null) {
            Instance = new DataSource();
        }
        return Instance;
    }

    public List<NewsModel> getAllNews() {
        return news;
    }

    public List<AuthorModel> getAllAuthors() {
        return authors;
    }
}

