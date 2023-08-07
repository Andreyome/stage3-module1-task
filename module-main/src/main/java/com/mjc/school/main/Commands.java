package com.mjc.school.main;


import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.web.impl.ConnectorImpl;

import java.util.Scanner;

public class Commands {
    Scanner scanner = new Scanner(System.in);
    ConnectorImpl connector = new ConnectorImpl();
    public Commands(){}
    public void readAll(){
        System.out.println("All news:");
        connector.readAll().forEach(System.out::println);
    }
    public void create (){
        System.out.println("Write news title: ");
        String title = scanner.nextLine();
        System.out.println("Write news content: ");
        String content = scanner.nextLine();
        System.out.println("Write news author id: ");
        long authorId = Long.parseLong(scanner.nextLine());
        connector.create(new NewsDTO(title,content,authorId));
    }
    public void getNewsById() {
            System.out.println("Write news id: ");
            System.out.println(connector.read(Long.parseLong(scanner.nextLine())));
}
    public void updateNews (){
        System.out.println("Write news id: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Write news title: ");
        String title = scanner.nextLine();
        System.out.println("Write news content: ");
        String content = scanner.nextLine();
        System.out.println("Write news author id: ");
        long authorId = Long.parseLong(scanner.nextLine());
        connector.update(new NewsDTO(id,title,content,authorId));
    }
    public void deleteNewsById (){
        System.out.println("Write news id: ");
        long id = Long.parseLong(scanner.nextLine());
        connector.delete(id);
    }

}
