package com.cs505.group.main.prototype;

/*
 * This is a subclass of Location that will add to it by
 * getting the value of street to the last two Strings for 
 * an API search that will give a better location service 
 * then the last class
 */

public class ExactLocation extends Location {

    /*
     * This string is added to this class that is not in the Location
     * but still includes what is in the abstract class and the Location Class
     */

    public String town;

    /*
     * Initialization class with an empty input
     */

    public ExactLocation() {

    }

    /*
     * Init with the variables
     */

    public ExactLocation(ExactLocation target) {
        super(target);
        if (target != null) {
            this.zip = target.zip;
            this.state = target.state;
            this.town = target.town;
        }
    }

    /*
     * This overwrites the clone that is in the parent class and
     * abstract class to return the prototype of type ExactLocation
     */

    @Override
    public Prototype clone() {
        return new ExactLocation(this);
    }

}
