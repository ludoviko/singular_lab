package com.lam.farm;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Root class for modeling social animals behaviours.
 *
 * @author L. Azuaje
 * @version 1.0
 * @since 2019-12-18
 */
public class Animal implements IAnimalSocial {
    private final static Logger LOGGER = Logger.getLogger("com.lam.farm");

    private String name;
    private String favoriteFood;
    private Set<IAnimalSocial> friends;

    /**
     * Animal no argument consructor.
     */
    public Animal() {
        this.friends = new HashSet<IAnimalSocial>();
    }

    /**
     * This method signature is for returning the name of the IAnimal.
     * @return String The name of the IAnimal.
     */
    public String getName() {
        return name;
    }

    /**
     * This method signature is for setting the name of the IAnimal.
     * @param name This is the new name.
     * @return void.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method signature is for returning the favoriteFood of the IAnimal.
     * @return String The favoriteFood of the IAnimal.
     */
    public String getFavoriteFood() {
        return favoriteFood;
    }

    /**
     * This method signature is for setting the favoriteFood of the IAnimal.
     * @param favoriteFood This is the new favoriteFood.
     * @return void.
     */
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    private Set<IAnimalSocial> findPotentialFriends(Set<IAnimalSocial> allAnimals) {
        Set<IAnimalSocial> potentialFriends = new HashSet<IAnimalSocial>();
        potentialFriends.addAll(allAnimals);
        potentialFriends.removeAll(this.friends);
        return potentialFriends;
    }

    /**
     * This method signature is for adding new friends to  IAnimalSocial.
     * @param allAnimals The animals with whom to make friends.
     * @return void.
     */
    public void makeFriendsFrom(Set<IAnimalSocial> allAnimals) {
        Random random = new Random();
        List<IAnimalSocial> allAnimalsList = new ArrayList<IAnimalSocial>();
        allAnimalsList.addAll(allAnimals);
        allAnimalsList.remove(this);
        Collections.shuffle(allAnimalsList);

        int topIndex = random.nextInt(allAnimals.size());
        if (topIndex == 0) {
            topIndex = 1;
        }

        for (int i = 0; i < topIndex; i++) {
            this.makeAFriend(allAnimalsList.get(i));
        }
    }

    private void makeAFriend(IAnimalSocial animal) {
        synchronized (this) {
            if (!animal.isFriendOf(animal)) {
                this.friends.add(animal);
                animal.getFriends().add(this);
                loggerFriendMade(this.getName(), animal.getName(), this.friends.size(), this.friendsNames());
                loggerFriendMade(animal.getName(), this.getName(), animal.getFriends().size(), animal.friendsNames());
            }
            ;
        }
    }

    private static void loggerFriendMade(String name, String otherName, int friendsSize, String friendsNames) {
        LOGGER.log(Level.WARNING, name + " has made a friend: " + otherName + ", has " + friendsSize +
                " and they are " + friendsNames);
    }

    private static void loggerFriendLost(String name, String otherName, int friendsSize, String friendsNames) {
        LOGGER.log(Level.WARNING, name + " has lost a friend: " + otherName + ", has " + friendsSize +
                " and they are " + friendsNames);
    }

    /**
     * Method for loosing one friend only if this has at least 2 friends.
     * @return void.
     */
    private synchronized void loseAFriend() {
        if (this.friends.size() <= 1) {
            return;
        }
        IAnimalSocial animal = chooseAFriendToLose();
        this.friends.remove(animal);
        animal.getFriends().remove(this);
        loggerFriendLost(this.getName(), animal.getName(), this.friends.size(), this.friendsNames());
        loggerFriendLost(animal.getName(), this.getName(), animal.getFriends().size(), animal.friendsNames());
    }

    /**
     *  Method that inccludes other action made within a day of life with any of the
     *  members of the sicial animals.
     * @return void.
     */
    public void liveOneDay(Set<IAnimalSocial> allAnimals) {
        this.loseAFriend();
        makeAFriend(this.chooseAFriendToMakeFrom(allAnimals));
    }

    /**
     * This method signature is for getting current friends of this..
     * @return A set of IAnimaloSocial.
     */
    public Set<IAnimalSocial> getFriends() {
        return this.friends;
    }

    /**
     *  Method for checking whether this animal is friend of another.
     *
     *  Friendship is not reflexive.
     *
     *  Friendship is symmetrical.
     *
     *  @param animal The animal on which the friendship is checked.
     * @return the result of the friendship checking as a boolean.
     */
    public boolean isFriendOf(IAnimalSocial animal) {
        return this.friends.contains(animal) && animal.getFriends().contains(this);
    }

    private IAnimalSocial chooseAFriendToLose() {
        Random random = new Random();
        List<IAnimalSocial> friendsList = new ArrayList<IAnimalSocial>();
        friendsList.addAll(friends);
        int index = random.nextInt(friends.size());
        return friendsList.get(index);
    }

    private IAnimalSocial chooseAFriendToMakeFrom(Set<IAnimalSocial> allAnimals) {
        Set<IAnimalSocial> potentialFriends = findPotentialFriends(allAnimals);
        potentialFriends.remove(this);
        Random random = new Random();
        int index = random.nextInt(potentialFriends.size());

        List<IAnimalSocial> potentialFriendsList = new ArrayList<IAnimalSocial>();
        potentialFriendsList.addAll(potentialFriends);

        return potentialFriendsList.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (getName() != null ? !getName().equals(animal.getName()) : animal.getName() != null) return false;
        if (getFavoriteFood() != null ? !getFavoriteFood().equals(animal.getFavoriteFood()) : animal.getFavoriteFood() != null)
            return false;
        return getFriends() != null ? getFriends().equals(animal.getFriends()) : animal.getFriends() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getFavoriteFood() != null ? getFavoriteFood().hashCode() : 0);
        return result;
    }

    /**
     * This method signature returns all friend's namaes as a string separated by coma.
     * @return all friend's namaes as a string separated by coma..
     */
    public String friendsNames() {
        StringBuilder builder = new StringBuilder();

        for (IAnimalSocial animal : this.friends) {
            builder.append(animal.getName() + " " + animal.getClass().getSimpleName() + ", ");
        }

        if (builder.length() > 0) {
            return builder.toString().substring(0, builder.toString().length() - 2);
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", number of friends=" + friends.size() +
                ", friends=[" + friendsNames() + ']' +
                '}';
    }
}
