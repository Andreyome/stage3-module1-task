package com.mjc.school.main;


import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.controller.impl.ControllerImpl;

import java.util.Scanner;

public class Commands {
    Scanner scanner = new Scanner(System.in);
    ControllerImpl connector = new ControllerImpl();
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
        connector.create(new NewsDto(title,content,authorId));
    }
    public void getNewsById() {
            System.out.println("Write news id: ");
            System.out.println(connector.readBy(Long.parseLong(scanner.nextLine())));
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
        connector.update(new NewsDto(id,title,content,authorId));
    }
    public void deleteNewsById (){
        System.out.println("Write news id: ");
        long id = Long.parseLong(scanner.nextLine());
        connector.delete(id);
    }

}
