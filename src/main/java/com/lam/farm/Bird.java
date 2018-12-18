package com.lam.farm;

/**
 * Class for modeling birds.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public class Bird extends  Animal implements IWings {
    private String units;
    private double wingsLength;

    /**
     *  Method  for getting the units of measure property.
     * @return the units of measure property as a string.
     */
    public String getUnits() {
        return units;
    }

    /**
     *  Method  for setting the type property.
     * @param units the new units of measure property.
     * @return void.
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     *  Method  for getting the lenght of wings property.
     * @return the length property as a double.
     */
    public double getLength() {
        return this.wingsLength;
    }

    /**
     *  Method  for setting the length of wings property.
     * @param length the new ength of wings property.
     * @return void.
     */
    public void setLength(double length) {
        this.wingsLength = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bird bird = (Bird) o;

        if (Double.compare(bird.wingsLength, wingsLength) != 0) return false;
        return getUnits() != null ? getUnits().equals(bird.getUnits()) : bird.getUnits() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (getUnits() != null ? getUnits().hashCode() : 0);
        temp = Double.doubleToLongBits(wingsLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "units='" + units + '\'' +
                ", wingsLength=" + wingsLength +
                "} " + super.toString();
    }
}
