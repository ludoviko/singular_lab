package com.lam.farm;

import java.util.Set;

/**
 * Interface IAnimal for social animal method abstractions.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface IAnimalSocial extends IAnimal{
    /**
     * This method signature is for adding new friends to  IAnimalSocial.
     * @param socialAnimals The animals with whom to make friends.
     * @return void.
     */
    void makeFriendsFrom(Set<IAnimalSocial> socialAnimals);

    /**
     * This method signature is for getting current friends of  IAnimaloSocial.
     * @return A set of IAnimaloSocial.
     */
    Set<IAnimalSocial>  getFriends();

    /**
     * This method signature returns all friend's namaes as a string separated by coma.
     * @return all friend's namaes as a string separated by coma..
     */
    String friendsNames();

    /**
     *  Method signature  that abstracts other action made within a day of life with any of the
     *  members of the sicial animals.
     * @return void.
     */
    void liveOneDay(Set<IAnimalSocial> allAnimals);

    /**
     *  Method signature  for checking whether this animal is friend of another.
     *  @param animal The animal on which the friendship is checked.
     * @return the result of the friendship checking as a boolean.
     */
    boolean isFriendOf(IAnimalSocial animal);
}
