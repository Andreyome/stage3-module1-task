package com.mjc.school.repository.data;

import com.mjc.school.repository.models.AuthorModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorData {
    private final String authorPath = "module-repository/src/main/resources/author.txt";
    List<AuthorModel> authors;
    private static volatile AuthorData Instance = new AuthorData();

    public AuthorData() {
        initiate();
    }

    public void initiate() {
        try (BufferedReader br = new BufferedReader(new FileReader(authorPath))) {
            List<String> tmp = br.lines().toList();
            authors =new ArrayList<>();
        for(int i = 1;i< tmp.size();i++)
            {
                authors.add(new AuthorModel(i,tmp.get(i-1)));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File: authors.txt not found.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static AuthorData getInstance() {
        AuthorData result = Instance;
        if(result == null){
            Instance = new AuthorData();
            result=Instance;
        }
        return result;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }
}
