/**
 * The Display class provides a text-based user interface for interacting with the Commenting Application.
 * It includes methods for handling user commands, displaying comments, and printing trends.
 */
package org.console;

import org.logic.Comment;
import org.logic.CommentDB;
import org.logic.InputValidator;

import org.logic.Trend;
import org.logic.interfaces.StartupControllerInterface;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Implements the DisplayInterface and provides methods for handling user commands and displaying information.
 */
public class Display implements DisplayInterface {
    /**
     * Atomic integer to track the selected comment ID.
     */
    public static final AtomicInteger selectedCommentId = new AtomicInteger();

    /**
     * Executes the specified command and performs corresponding actions on the provided CommentDB.
     *
     * @param command   The command to be executed.
     */
    public static void Menu(String command) {
        List<String> command_words = Arrays.stream(command.split(" ")).toList();
        String commandType = command_words.get(0);
        List<String> concat_command_words = concatenateStringList(command_words).stream()
                .map(s -> s.replace("\"", ""))
                .collect(Collectors.toList());
        Display.clearConsole();
        Display.PrintTitle();
        CommentDB commentDB = new CommentDB();
        switch (commandType.toLowerCase()) {
            case "inser":
            case "insert":
                Map<String, String> paramMap = ListToParamMap(concat_command_words);
                for (int i = 0; i < concat_command_words.size(); i += 2) {
                    if (concat_command_words.get(i).startsWith("-")) {
                        paramMap.put(concat_command_words.get(i), concat_command_words.get(i + 1));
                    }
                }
                if (InputValidator.ValidateInputCommand(paramMap)) {
                    if (!paramMap.containsKey("-s")) {
                        paramMap.put("-s", "Anonymous");
                    }
                    if (!paramMap.containsKey("-d")) {
                        paramMap.put("-d", LocalDate.now().toString());
                    }
                    Comment comment = new Comment(paramMap.get("-e"), paramMap.get("-c"), Integer.parseInt(paramMap.get("-i")), Date.valueOf(paramMap.get("-d")), paramMap.get("-s"));
                    commentDB.save(comment);
                    System.out.println("Inserted a new comment successfully");
                } else {
                    System.out.println("Entered insert command wrongly");
                }
                break;
            case "del":
            case "delet":
            case "delete":
                if (!InputValidator.idContainedInList(commentDB,selectedCommentId.get())) {
                    commentDB.delete(commentDB.list().stream()
                            .filter(comment -> comment.getId() == selectedCommentId.get())
                            .collect(Collectors.toList()).get(0));
                    System.out.println("Comment deleted successfully");
                } else {
                    System.out.println("Comment with selected id was not found");
                }
                break;
            case "sel":
            case "selec":
            case "select":
                try {
                    selectedCommentId.set(Integer.parseInt(concat_command_words.get(0)));
                    if (!InputValidator.idContainedInList(commentDB,selectedCommentId.get())) {
                        System.out.println("Comment with selected id was not found");
                    } else {
                        System.out.println("Selected comment with id " + selectedCommentId.get());
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Selected id is not a valid number");
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
            case "quit":
            case "exit":
            case "end":
                StartupControllerInterface.stop();
                break;
            default:
                System.out.println("No such command found");
        }
    }

    /**
     * Clears the console screen.
     */
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

    /**
     * Prints the default title for the commenting application.
     */
    public static void PrintTitle() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("----------------------Commenting Application----------------------");
        System.out.println("------------------------------------------------------------------");
    }

    /**
     * Prints a custom title for the commenting application.
     *
     * @param title The title to be printed.
     */
    public static void PrintTitle(String title) {
        String tabulation = StringFromRepetetiveChar('-', title.length());
        System.out.println(tabulation + tabulation + tabulation);
        System.out.println(tabulation + title + tabulation);
    }

    /**
     * Generates a string consisting of repeated characters.
     *
     * @param c    The character to be repeated.
     * @param reps The number of times the character should be repeated.
     * @return A string with the repeated characters.
     */
    public static String StringFromRepetetiveChar(char c, Integer reps) {
        String repetetiveCharChain = "";
        for (int i = 0; i < reps; i++) {
            repetetiveCharChain += c;
        }
        return repetetiveCharChain;
    }

    /**
     * Converts a list of command words into a parameter map.
     *
     * @param concat_command_words The list of command words to be converted.
     * @return A map containing parameter-value pairs.
     */
    public static Map<String, String> ListToParamMap(List<String> concat_command_words) {
        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < concat_command_words.size(); i += 2) {
            if (concat_command_words.get(i).startsWith("-")) {
                paramMap.put(concat_command_words.get(i), concat_command_words.get(i + 1));
            }
        }
        return paramMap;
    }

    /**
     * Concatenates command words that are not parameters into a list.
     *
     * @param command_words The list of command words to be concatenated.
     * @return A list of concatenated command words.
     */
    public static List<String> concatenateStringList(List<String> command_words) {
        List<String> concat_command_words = new ArrayList<>();
        String value_concatenated = "";
        for (int i = 1; i < command_words.size(); i++) {
            value_concatenated = command_words.get(i);
            if (!command_words.get(i).startsWith("-")) {
                if (i != command_words.size() - 1) {
                    while (!command_words.get(i + 1).startsWith("-")) {
                        value_concatenated += " " + command_words.get(i + 1);
                        i++;
                        if (i == command_words.size() - 1) {
                            break;
                        }
                    }
                }
            }
            concat_command_words.add(value_concatenated);
        }
        return concat_command_words;
    }

    /**
     * Prints the details of the provided list of comments.
     *
     * @param commentList The list of comments to be printed.
     */
    public static void printComments(List<Comment> commentList) {
        commentList.stream().forEach(comment -> {
            System.out.println("ID:\t" + comment.getId() + "\tIMPORTANCE:\t" + comment.getImportance() + "\tEMPLOYEE:\t" + comment.getEmployee() + "\tDATE:\t" + comment.getDate());
            System.out.println("Comment:\t" + comment.getText());
            System.out.println("Sent by:\t" + comment.getSender());
            System.out.println();
        });
    }

    /**
     * Prints the details of the provided list of trends.
     *
     * @param TrendList The list of trends to be printed.
     */
    public static void printTrends(List<Trend> TrendList) {
        String format = "%-20s%-20.2f%-20.2f%-20s%n";
        System.out.printf("%-20s%-20s%-20s%-20s%n", "EMPLOYEE", "EARLIER", "CURRENT WEEK", "TREND");
        TrendList.forEach(trend -> {
            System.out.printf(format, trend.getEmployee(), trend.getEarlier(), trend.getCurrWeek(), trend.getTrend());
        });
    }
}
