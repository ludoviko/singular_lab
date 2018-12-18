package com.lam.farm;
/**
 * Interface ISpeaker for adding talking behaviour to animals.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public interface ISpeaker {
    /**
     *  Method signature  for checking whether this object can speak.
     * @return the result of the speaker property checking as a boolean.
     */
    boolean isSpeaker();

    /**
     * This method signature is for setting the speaker property of the animal.
     * @param speaker This is the new value for the property speaker.
     * @return void.
     */
    void setSpeaker(boolean speaker);
}
