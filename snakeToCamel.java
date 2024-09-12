/*
 * Name : Rahul Ganeshwar Patil
 * Date : 12/09/2024
 * Description : [Make a program that changes snake case to camel case,
 * 				 if input is not in snake case then convert it into snake case first and then convert it into camel case. ]
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class snakeToCamel {
	final static Scanner input = new Scanner(System.in);
	final static Constant constant = new Constant();
    public static void main(String[] args) {
        
        System.out.println(constant.ENTER_INPUT);
        String mainString = input.nextLine();
        if (mainString == null || mainString.isEmpty()) {
            System.out.println(constant.EMPTY_STRING);
            input.close();
            return;
        }
        mainString = mainString.replaceAll("[" + Pattern.quote(constant.noNeedCharacters) + "]", " ");
        mainString = mainString.toLowerCase();
        System.out.println(constant.SNAKE_CASE + toSnakeCase(mainString, "", false)); 
        System.out.println(constant.CAMAL_CASE + toCamelCase(mainString, false, true, "")); 
        input.close();
    }

    //to camel case is used to convert given String in camel case
    private static String toCamelCase(String mainString, boolean makeNextUppercase, boolean isFirstCharacter, String result) {
        if (mainString.isEmpty()) {
            return result;
        }
        char currentCharacter = mainString.charAt(0);
        if (Character.isSpaceChar(currentCharacter) || Character.isWhitespace(currentCharacter)) {
            return toCamelCase(mainString.substring(1), true, isFirstCharacter, result);
        } else if (isFirstCharacter) {
            result += currentCharacter;
            return toCamelCase(mainString.substring(1), false, false, result);
        } else if (makeNextUppercase) {
            result += Character.toTitleCase(currentCharacter);
            return toCamelCase(mainString.substring(1), false, false, result);
        } else {
            result += currentCharacter;
            return toCamelCase(mainString.substring(1), false, false, result);
        }
    }
    
    //to snake case is used to convert given String into snake case
    public static String toSnakeCase(String mainString, String result, boolean appendUnderscore) {
        if (mainString.isEmpty()) {
            return result;
        }
        char currentCharacter = mainString.charAt(0);
        if (Character.isSpaceChar(currentCharacter) || Character.isWhitespace(currentCharacter)) {
            if (appendUnderscore) {
                result += "_";
            }
            return toSnakeCase(mainString.substring(1), result, false);
        } else {
            result += currentCharacter;
            return toSnakeCase(mainString.substring(1), result, true);
        }
    }
    
}
