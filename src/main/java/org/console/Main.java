package org.console;

import org.logic.StartupController;

import java.nio.charset.StandardCharsets;

import static org.console.DisplayInterface.Menu;

public class Main {

    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");
        StartupController.start();
    }


}