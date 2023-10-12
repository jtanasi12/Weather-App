package com.cs505.group.main.validation;

/**
 * author: Maurice Johnson
 *
 * This is an implementation of the ValidationStrategy.
 * Within validate() we will provide logic to validate
 * whether a user entered Yes, Y, No, N, or an invalid value.
 */
public class ContinueValidationStrategy implements ValidationStrategy {

    private static boolean isNo;

    /**
     * method to validate "continue" input - implementing from interface
     * @param input
     * @return String
     */
    @Override
    public String validate(String input) {
        if ((isYesOrNo(input) == false)) 
        	return "Must enter [Y/Yes or N/No]";
        return null;
    }

    /**
     * check if the users input is null or an empty string
     * @param input
     * @return
     */
    private boolean isEmpty(String input){
        if (input == null) return true;
        if (input.length()==0) return true;
        return false;
    }

    /**
     * check if the users input is considered yes or no (valid input)
     * @param input
     * @return
     */
    private boolean isYesOrNo(String input){
        if (isEmpty(input.trim())) return false;
        return isYes(input) || isNo(input);
    }

    /**
     * check if the users input is considered yes
     * @param input
     * @return
     */
    private boolean isYes(String input){
        if (input.equalsIgnoreCase("y")){
            isNo = false;
            return true;
        }
        if (input.equalsIgnoreCase("yes")){
            isNo = false;
            return true;
        }
        return false;
    }

    /**
     * check if the users input is considered no
     * @param input
     * @return
     */
    private boolean isNo(String input){
        if (input.equalsIgnoreCase("n")){
            isNo = true;
            return true;
        }
        if (input.equalsIgnoreCase("no")){
            isNo = true;
            return true;
        }
        return false;
    }

    /**
     * static method to check if user input is no.
     * We will only do this check once we know if
     * the input is "valid" in the first place.
     *
     * @return
     */
    public static boolean isNo() {
        return isNo;
    }
}
