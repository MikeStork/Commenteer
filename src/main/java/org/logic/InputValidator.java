package org.logic;

import java.util.Map;

public class InputValidator {
    public static boolean ValidateInputCommand(Map<String, String> paramMap){
            // Regular expression for name validation
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
            if(!isValidDateFormat(paramMap.get("-d"))){
                return false;
            }
        }
        return true;
    }
    private static boolean isValidDateFormat(String date) {
        String dateFormatRegex = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        return date.matches(dateFormatRegex);
    }
}
