package com.mjc.school.repository.data;

import com.mjc.school.repository.models.NewsModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsData {
    private final String contentPath = "module-repository/src/main/resources/content.txt";
    private final String titlePath = "module-repository/src/main/resources/news.txt";
    private static List<NewsModel> news;
    private static volatile NewsData Instance = new NewsData();

    public NewsData() {
        initiate();
    }

    public void initiate() {
        try (BufferedReader cr = new BufferedReader(new FileReader(contentPath));
        BufferedReader nr = new BufferedReader(new FileReader(titlePath))) {
            List<String> tmp = cr.lines().toList();
            List<String> titlesTmp = nr.lines().toList();
            news =new ArrayList<>();
            for(int i = 1;i<=tmp.size();i++)
            {
                news.add(new NewsModel(i,titlesTmp.get(i-1),tmp.get(i-1), LocalDateTime.now(),LocalDateTime.now(),i));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static NewsData getInstance() {
        NewsData result = Instance;
        if(result == null){
            Instance = new NewsData();
            result = Instance;
        }
        return result;
    }

    public List<NewsModel> getNews() {
        return news;
    }

}
