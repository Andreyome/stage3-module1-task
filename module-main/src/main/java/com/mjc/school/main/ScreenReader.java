package com.mjc.school.main;

import java.util.Scanner;

public class ScreenReader {
    Commands commands = new Commands();
    Scanner scanner = new Scanner(System.in);
    public ScreenReader(){
        run();
    }
    public void run() {
        while (true) {
            System.out.println("Choose command:" + "\n" + "1-read all" + "\n" + "2-read news by id" + "\n" + "3-create news" + "\n" + "4-update news" + "\n" + "5-delete news"+"\n"+"0-Exit");
            switch (scanner.nextLine()) {
                case "1":
                    commands.readAll();
                    break;
                case "2":
                    commands.getNewsById();
                    break;
                case "3":
                    commands.create();
                    break;
                case "4":
                    commands.updateNews();
                    break;
                case "5":
                    commands.deleteNewsById();
                    break;
                case "0":
                    System.out.println("Thank you for using our news program!");
                    System.exit(0);
                    break;
            }
        }
    }
}
