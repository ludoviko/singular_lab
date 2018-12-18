package com.lam.farm;
/**
 * Interface IType for adding type (animal description) behaviour to animals.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface IType {
    /**
     *  Method signature for getting the type property.
     * @return the type property as a string.
     */
    String getType();
    /**
     *  Method signature for setting the type property.
     * @param type the new type property.
     * @return void.
     */
    void setType(String type);
}
