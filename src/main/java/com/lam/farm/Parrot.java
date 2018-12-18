package com.lam.farm;
/**
 * Class for modeling parrots.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public class Parrot extends Bird implements ISpeaker {
    private boolean speaker;

    /**
     *  Method signature for checking whether this object can speak.
     * @return the result of the speaker property checking as a boolean.
     */    public boolean isSpeaker() {
        return speaker;
    }

    /**
     * This method signature is for setting the speaker property of the animal.
     * @param speaker This is the new value for the property speaker.
     * @return void.
     */    public void setSpeaker(boolean speaker) {
        this.speaker = speaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Parrot parrot = (Parrot) o;

        return isSpeaker() == parrot.isSpeaker();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isSpeaker() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "speaker=" + speaker +
                "} " + super.toString();
    }
}
