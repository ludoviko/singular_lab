package com.lam.farm;
/**
 * Interface IBroiler for adding behaviour to animals, mainly possibility of being broiled.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface IBroiler {
    /**
     *  Method signature  for checking whether this object is broiler.
     * @return the result of the broiler checking as a boolean.
     */
    boolean isBroiler();
    /**
     * This method signature is for setting the broiler property of the animal.
     * @param broiler This is the new value for the property boiler.
     * @return void.
     */
    void setBroiler(boolean broiler);
}
