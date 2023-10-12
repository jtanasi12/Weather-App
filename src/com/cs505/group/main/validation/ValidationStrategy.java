package com.cs505.group.main.validation;

/**
 * author: Maurice Johnson
 *
 * This is the ValidationStrategy interface. We provide a validate()
 * method for implementing classes to implement
 */
public interface ValidationStrategy {
    String validate(String input);
}
