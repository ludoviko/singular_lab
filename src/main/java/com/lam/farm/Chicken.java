package com.lam.farm;
/**
 * Class for modeling chickens.
 *
 * @author  L. Azuaje
 * @version 1.0
 * @since   2019-12-18
 *
 */
public class Chicken extends Bird implements IBroiler{
    private boolean broiler;

    /**
     *  Method signature  for checking whether this object is broiler.
     * @return the result of the broiler checking as a boolean.
     */
    public boolean isBroiler() {
        return broiler;
    }

    /**
     * This method signature is for setting the broiler property of the animal.
     * @param broiler This is the new value for the property boiler.
     * @return void.
     */
    public void setBroiler(boolean broiler) {
        this.broiler = broiler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chicken chicken = (Chicken) o;

        return isBroiler() == chicken.isBroiler();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isBroiler() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "broiler=" + broiler +
                "} " + super.toString();
    }
}
