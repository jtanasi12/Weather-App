package com.cs505.group.main.prototype;

/*  
 * This is a prototype pattern to create a list of possible 
 * possible combinations of what the user can input for locations
 * to search with
 */

public abstract class Prototype {

    /*
     * This String state will be the baseline
     * that every subclass should have this
     */

    public int zip;

    /*
     * Init
     */

    public Prototype() {

    }

    /*
     * Init with a state
     */

    public Prototype(Prototype target) {
        if (target != null) {
            this.zip = target.zip;
        }
    }

    /*
     * This will be the functionality that
     * every subclass will need to have
     */

    public abstract Prototype clone();

}
