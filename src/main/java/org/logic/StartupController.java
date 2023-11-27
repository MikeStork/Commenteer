package org.logic;


import org.console.DisplayInterface;
import org.logic.interfaces.StartupControllerInterface;

import java.nio.charset.StandardCharsets;

import static java.lang.System.exit;
import static org.console.DisplayInterface.*;

public class StartupController implements StartupControllerInterface {
    public static void start(){
    DisplayInterface.clearConsole();
        DisplayInterface.PrintTitle();
        while (true) {
        java.util.Scanner scanner = new java.util.Scanner(System.in, StandardCharsets.UTF_8);
        Menu(scanner.nextLine());
    }
    }
    public static void stop(){
        exit(0);
    }
}
