package com.lam.farm;

/**
 * Class for modeling dogs.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */public class Dog extends Animal implements IType {
    private String type;

    /**
     *  Method signature for getting the type property.
     * @return the type property as a string.
     */
    public String getType() {
        return type;
    }


    /**
     *  Method signature for setting the type property.
     * @param type the new type property.
     * @return void.
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dog dog = (Dog) o;

        if (getType() != null ? !getType().equals(dog.getType()) : dog.getType() != null) return false;
        if (getName() != null ? !getName().equals(dog.getName()) : dog.getName() != null) return false;
        return getFavoriteFood() != null ? getFavoriteFood().equals(dog.getFavoriteFood()) : dog.getFavoriteFood() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getFavoriteFood() != null ? getFavoriteFood().hashCode() : 0);
        return result;
    }
}
