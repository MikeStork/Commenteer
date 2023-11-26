package org.console;

import org.logic.CommentDB;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import org.console.Display;

public class Main {

    public static void main(String[] args) {
        Display.clearConsole();
        Display.PrintTitle();
        while (true) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            Menu(scanner.nextLine());
        }
    }

    public static void Menu(String command){
        String [] command_words = command.split(" ");
        Display.clearConsole();
        Display.PrintTitle();
        switch(command_words[0]){
            case "insert":
                System.out.println("In insert command block");
                break;
            case "delete":
                break;
            case "list":
                org.logic.CommentDB commentDB = new CommentDB();
                System.out.println(commentDB.list());
                break;
            case "trend":
                break;
            default:
                System.out.println("No such command found");
        }
    }

}