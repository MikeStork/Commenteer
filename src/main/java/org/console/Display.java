package org.console;

import org.logic.Comment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Display {

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void PrintTitle(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("----------------------Commenting Application----------------------");
        System.out.println("------------------------------------------------------------------");
    }
    public static void PrintTitle(String title){
        String tabulation = StringFromRepetetiveChar('-',title.length());
        System.out.println(tabulation+tabulation+tabulation);
        System.out.println(tabulation+title+tabulation);
    }

    public static String StringFromRepetetiveChar(char c, Integer reps){
        String repetetiveCharChain = "";
        for (int i = 0; i < reps; i++) {
            repetetiveCharChain+=c;
        }
        return repetetiveCharChain;
    }
    public static Map<String,String> ListToParamMap(List<String> concat_command_words){
        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < concat_command_words.size(); i+=2) {
            if(concat_command_words.get(i).startsWith("-")){
                paramMap.put(concat_command_words.get(i), concat_command_words.get(i+1));
            }
        }
        return paramMap;
    }
    public static List<String> concatenateStringList(List<String> command_words){
        List<String> concat_command_words = new ArrayList<>();
        String value_concatenated = "";
        for (int i = 1; i < command_words.size(); i++) {
            value_concatenated=command_words.get(i);
            if(!command_words.get(i).startsWith("-")) {
                if(i != command_words.size()-1){
                    while(!command_words.get(i+1).startsWith("-")){
                        value_concatenated+=" "+command_words.get(i+1);
                        i++;
                        if (i == command_words.size()-1){
                            break;
                        }
                    }
                }
            }
            concat_command_words.add(value_concatenated);
        }
        return concat_command_words;
    }
    public static void printComments(List<Comment> commentList){
        commentList.stream().forEach(comment -> {
            System.out.println("ID:\t"+comment.getId()+"\tIMPORTANCE:\t"+comment.getImportance()+"\tEMPLOYEE:\t"+comment.getEmployee()+"\tDATE:\t"+comment.getDate());
            System.out.println("Comment:\t"+comment.getText());
            System.out.println("Sent by:\t"+comment.getSender());
            System.out.println();
        });
    }
}
