package com.cs505.group.main.validation;


import com.cs505.group.main.util.LoggerUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Maurice Johnson
 *
 * This is the validation context class. This class takes in an array of strategies
 * and sets our instance variable to that value.  We then execute the validate method
 * on each strategy and check for any errors.
 */
public class ValidationContext {

    private ValidationStrategy[] validationStrategies;

    public ValidationContext(ValidationStrategy[] validationStrategies){
        this.validationStrategies = validationStrategies;
    }

    /**
     * validate user input against each validation
     * strategy and check for any errors that may occur
     * @param input
     * @return ValidationResponse
     */
    public ValidationResponse validate(String input){
        LoggerUtil.log("ValidationContext - validate()\n");

        ValidationResponse validationResponse = new ValidationResponse();
        List<String> errors = new ArrayList<>();

        for (ValidationStrategy strat : validationStrategies){
            String response = strat.validate(input);
            if (response != null){
                errors.add(response);
            }
        }

        if (errors.size() > 0){
            validationResponse.setMessage("Input is invalid");
            System.out.println("Input is invalid");
            System.out.println(errors);
            validationResponse.setErrors(errors);
            validationResponse.setValid(false);
            return validationResponse;
        } else {
            validationResponse.setMessage("Input is valid");
            System.out.println("Input is valid");
            validationResponse.setErrors(errors);
            validationResponse.setValid(true);
        }

        return validationResponse;
    }

}
