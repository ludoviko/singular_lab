package com.lam.farm;
/**
 * Interface IType for adding wing-related data behaviour to animals.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface IWings {
    /**
     *  Method signature for getting the units of measure property.
     * @return the units of measure property as a string.
     */
    String getUnits();

    /**
     *  Method signature for setting the type property.
     * @param units the new units of measure property.
     * @return void.
     */
    void setUnits(String units);

    /**
     *  Method signature for getting the lenght of wings property.
     * @return the length property as a double.
     */
    double getLength();

    /**
     *  Method signature for setting the length of wings property.
     * @param length the new ength of wings property.
     * @return void.
     */
    void setLength(double length);
}
