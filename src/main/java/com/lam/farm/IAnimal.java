package com.lam.farm;

/**
 * Interface IAnimal for  animal method abstractions.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface IAnimal {
    /**
     * This method signature is for returning the name of the IAnimal.
     * @return String The name of the IAnimal.
     */
    String getName();
    /**
     * This method signature is for setting the name of the IAnimal.
     * @param name This is the new name.
     * @return void.
     */
    void setName(String name);

    /**
     * This method signature is for returning the favoriteFood of the IAnimal.
     * @return String The favoriteFood of the IAnimal.
     */
    String getFavoriteFood();
    /**
     * This method signature is for setting the favoriteFood of the IAnimal.
     * @param favoriteFood This is the new favoriteFood.
     * @return void.
     */
    void setFavoriteFood(String favoriteFood);
}
