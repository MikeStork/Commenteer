package org.console;

import org.logic.Comment;
import org.logic.CommentDB;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.logic.InputValidator;

import static org.console.Display.*;

public class Main {

    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        Display.clearConsole();
        Display.PrintTitle();
        while (true) {
            java.util.Scanner scanner = new java.util.Scanner(System.in, "UTF-8");
            Menu(scanner.nextLine());
        }
    }

        private static final AtomicInteger selectedCommentId = new AtomicInteger();
    public static void Menu(String command){

        List<String> command_words = Arrays.stream(command.split(" ")).toList();
        String commandType = command_words.get(0);
        List<String> concat_command_words = concatenateStringList(command_words).stream()
                .map(s -> s.replace("\"", ""))
                .collect(Collectors.toList());
        Display.clearConsole();
        Display.PrintTitle();
        CommentDB commentDB = new CommentDB();
        switch(commandType.toLowerCase()){
            case "inser":
            case "insert":
                Map<String, String> paramMap = ListToParamMap(concat_command_words);
                for (int i = 0; i < concat_command_words.size(); i+=2) {
                    if(concat_command_words.get(i).startsWith("-")){
                        paramMap.put(concat_command_words.get(i), concat_command_words.get(i+1));
                    }
                }
                if(InputValidator.ValidateInputCommand(paramMap)){
                    if (paramMap.containsKey("-s") == false){
                        paramMap.put("-s","Anonymous");
                    }
                    if (paramMap.containsKey("-d") == false){
                        paramMap.put("-d", LocalDate.now().toString());
                    }
                    Comment comment = new Comment(paramMap.get("-e"), paramMap.get("-c"), Integer.parseInt(paramMap.get("-i")), Date.valueOf(paramMap.get("-d")), paramMap.get("-s"));
                    commentDB.save(comment);
                    System.out.println("Inserted a new comment succesfully");
                }else{
                    System.out.println("Entered insert command wrongly");
                }
                break;
            case "del":
            case "delet":
            case "delete":
                if(commentDB.list().stream().anyMatch(comment->comment.getId()==selectedCommentId.get())){
                    commentDB.delete(commentDB.list().stream()
                            .filter(comment -> comment.getId()==selectedCommentId.get())
                            .collect(Collectors.toList()).get(0));
                    System.out.println("Comment deleted succesfully");
                    }
                else{
                    System.out.println("Comment with selected id was not found");
                    }
                    break;
            case "sel":
            case "selec":
            case "select":
                        try{
                            selectedCommentId.set(Integer.parseInt(concat_command_words.get(0)));
                    if(!commentDB.list().stream().anyMatch(comment->comment.getId()==selectedCommentId.get())){
                        System.out.println("Comment with selected id was not found");
                    }else {
                        System.out.println("Selected comment with id " + selectedCommentId.get());
                    }
                    break;
                        }catch (Exception e){
                            System.out.println("Selected id is not valid number");
                        }
                break;
            case "li":
            case "lis":
            case "list":
                 printComments(commentDB.list());
                break;
            case "trend":
            case "trends":
                printTrends(commentDB.trend());
                break;
            default:
                System.out.println("No such command found");
        }
    }

}