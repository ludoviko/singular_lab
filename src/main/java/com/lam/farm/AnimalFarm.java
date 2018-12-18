package com.lam.farm;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Class for launching and run animal objects.
 */

public class AnimalFarm {
    private final static Logger LOGGER = Logger.getLogger("com.lam.farm");

    private AnimalFarm() {
    }

    /**
     * Method for running the animal farm data.
     *
     * @param args Number of days to live, if not provided this defaults to 1.
     */
    public final void run(String[] args) {
        int days = 1;
        if (args != null && args.length == 1 ) {
            days = Integer.parseInt(args[0]);
        }

        PrintStream out = System.out;
        Set<IAnimalSocial> allAnimals = new HashSet<IAnimalSocial>();

        Dog dog1 = new Dog();
        dog1.setName("Killian");
        dog1.setType("Hunting dog");
        dog1.setFavoriteFood("Meat");

        Dog dog2 = new Dog();
        dog2.setName("Peter");
        dog2.setType("Sport dog");
        dog2.setFavoriteFood("Pedigree");

        Dog dog3 = new Dog();
        dog3.setName("Rocky");
        dog3.setType("Working dog");
        dog3.setFavoriteFood("Fresh meat");

        Dog lassie = new Dog();
        lassie.setName("Lassie");
        lassie.setType("Rough Collie");
        // Lassie does not eat other animals at all.
        lassie.setFavoriteFood("Strict vegetarian");

        Dog milu = new Dog();
        milu.setName("Fox terrier");
        milu.setType("Fox terrier");
        // Milu does not eat other animals at all.
        milu.setFavoriteFood("Strict vegetarian");

        Parrot parrot1 = new Parrot();
        parrot1.setName("Buddy");
        parrot1.setFavoriteFood("nuts");
        parrot1.setUnits("meter");
        parrot1.setLength(0.25);
        // Actually Buddy is learning to speak.
        parrot1.setSpeaker(false);

        Parrot parrot2 = new Parrot();
        parrot2.setName("Harley");
        parrot2.setFavoriteFood("corn");
        parrot2.setUnits("meter");
        parrot2.setLength(0.5);
        parrot2.setSpeaker(true);

        Chicken chicken1 = new Chicken();
        chicken1.setName("Yolko Ono");
        chicken1.setFavoriteFood("rice");
        chicken1.setUnits("meter");
        chicken1.setLength(0.75);
        chicken1.setBroiler(true);

        Chicken chicken2 = new Chicken();
        chicken2.setName("Chicken Little");
        chicken2.setFavoriteFood("seeds");
        chicken2.setUnits("meter");
        chicken2.setLength(0.20);
        // Chicken Little is too young to be broiled.
        chicken1.setBroiler(false);

        allAnimals.add(dog1);
        allAnimals.add(dog2);
        allAnimals.add(dog3);
        allAnimals.add(lassie);
        allAnimals.add(milu);
        allAnimals.add(parrot1);
        allAnimals.add(parrot2);
        allAnimals.add(chicken1);
        allAnimals.add(chicken2);

        LOGGER.log(Level.WARNING, "When our animals are young they do not have any friend...");
        for (IAnimalSocial animal : allAnimals)  {
            //out.println(animal);
            LOGGER.log(Level.WARNING, animal.toString());
        }
        LOGGER.log(Level.WARNING, "    ");

        // Set friends to each animal.
        LOGGER.log(Level.WARNING, "But at the party they make some...");
        for (IAnimalSocial animal : allAnimals)  {
            animal.makeFriendsFrom(allAnimals);
        }
        LOGGER.log(Level.WARNING, "    ");

        LOGGER.log(Level.WARNING, "The party is over, they have made new friends...");
        for (IAnimalSocial animal : allAnimals)  {
            LOGGER.log(Level.WARNING, animal.toString());
        }
        LOGGER.log(Level.WARNING, "");

        for (int day = 0; day < days; day++) {
            LOGGER.log(Level.WARNING, "They lose one friend and make a new one from day to day: " + day + " day.");
            // Changes in friendship.
            for (IAnimalSocial animal : allAnimals)  {
                animal.liveOneDay(allAnimals);
            }
        }

        LOGGER.log(Level.WARNING, "");
        LOGGER.log(Level.WARNING, "Finally these are the friends they have got...");
        for (IAnimalSocial animal : allAnimals)  {
            LOGGER.log(Level.WARNING, animal.toString());
        }
        LOGGER.log(Level.WARNING, "");
    }

    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm();
        farm.run(args);
    }
}
