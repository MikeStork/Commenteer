/**
 * Interface for starting and controlling the main functionality of a commenting application.
 */
package org.logic.interfaces;

import org.console.DisplayInterface;

import java.nio.charset.StandardCharsets;

import static java.lang.System.exit;
import static org.console.DisplayInterface.Menu;

public interface StartupControllerInterface {

    /**
     * Starts the commenting application.
     */
    static void start(){
        DisplayInterface.clearConsole();
        DisplayInterface.PrintTitle();
        while (true) {
            java.util.Scanner scanner = new java.util.Scanner(System.in, StandardCharsets.UTF_8);
            Menu(scanner.nextLine());
        }
    }
    /**
     * Stops the commenting application.
     */
    public static void stop(){
        exit(0);
    }
}
