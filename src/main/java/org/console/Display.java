package org.console;

import java.io.IOException;

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
}
