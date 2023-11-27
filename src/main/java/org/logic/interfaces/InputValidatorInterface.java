/**
 * Interface for validating input commands in a commenting application.
 */
package org.logic.interfaces;

import java.util.Map;

public interface InputValidatorInterface {

    /**
     * Validates the input command parameters.
     *
     * @param paramMap The map of command parameters to be validated.
     * @return True if the input command is valid, false otherwise.
     */
    public static boolean ValidateInputCommand(Map<String, String> paramMap){
        if(paramMap.isEmpty()){
            return false;
        }
        if((!paramMap.containsKey("-c") ||
                !paramMap.containsKey("-i") ||
                !paramMap.containsKey("-e")
        )
        ){

            return false;
        }
        if((paramMap.get("-c").isEmpty() ||
                paramMap.get("-i").isEmpty() ||
                paramMap.get("-e").isEmpty()
        ))
        {
            return false;
        }
        if(paramMap.containsKey("-d")){
            return isValidDateFormat(paramMap.get("-d"));
        }
        return true;
    }

    /**
     * Checks if the date format is valid.
     *
     * @param date The date to be validated.
     * @return True if the date format is valid, false otherwise.
     */
    private static boolean isValidDateFormat(String date) {
        String dateFormatRegex = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        return date.matches(dateFormatRegex);
    }
}
