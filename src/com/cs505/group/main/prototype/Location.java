package com.cs505.group.main.prototype;

/*
 * This is a sub class for Prototype that adds
 * the town as a variable for location searching
 */

public class Location extends Prototype {

    /*
     * This string is added to this class that is not in the abstract
     * but still includes what is in the abstract
     */

    public String state;

    /*
     * Initialization class with an empty input
     */

    public Location() {

    }

    /*
     * Init with the varia
     */

    public Location(Location target) {
        super(target);
        if (target != null) {
            this.zip = target.zip;
            this.state = target.state;
        }
    }

    /*
     * Overwrite that will return Prototype with additional string town
     */

    @Override
    public Prototype clone() {
        return new Location(this);
    }

}
