package com.lam.farm;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.CombinableMatcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.util.HashSet;
import java.util.Set;

public class AnimalFarmTest {
    Set<IAnimalSocial> allAnimals;
    int days = 365;

    @Before
    public void setUp() throws Exception {
        allAnimals = new HashSet<IAnimalSocial>();

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
        // Chicken Little is too young to be broiler.
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
    }

    @After
    public void tearDown() throws Exception {
        allAnimals = null;
    }

    @Test
    public void testYoungAnimalsHaveNoFriends() {
        for (IAnimalSocial animal : allAnimals)  {
            Assert.assertThat("Young animals do not have friends.", animal.getFriends().size(), CoreMatchers.is(CoreMatchers.equalTo(0)));
        }
    }

    @Test
    public void testAfterThePartyTheyHaveFriends() {
        for (IAnimalSocial animal : allAnimals)  {
            animal.makeFriendsFrom(allAnimals);
            Assert.assertTrue("After the party every animal has many friends.", ! animal.getFriends().isEmpty());
        }
    }

    @Test
    public void testLiveAndMakeAndLoseFriends() {
        for (int day = 0; day < days; day++) {
            // Changes in friendship.
            for (IAnimalSocial animal : allAnimals)  {
                animal.liveOneDay(allAnimals);
            }
        }

        for (IAnimalSocial animal : allAnimals)  {
            Assert.assertTrue("After llving so many days every animal has some friends, old and new ones.", ! animal.getFriends().isEmpty());
        }
    }

    @Test
    public void testSymmetricalFriendship() {
        for (IAnimalSocial animal : allAnimals)  {
            animal.makeFriendsFrom(allAnimals);
        }
        for (IAnimalSocial animal : allAnimals)  {
            for (IAnimalSocial friend : animal.getFriends()) {
                Assert.assertTrue("A is friend of B.", animal.isFriendOf(friend));
                Assert.assertTrue("B is friend of A.", friend.isFriendOf(animal));
            }
        }
    }

    @Test
    public void testNotReflexiveFrienship() {
        for (IAnimalSocial animal : allAnimals)  {
            animal.makeFriendsFrom(allAnimals);
        }
        for (IAnimalSocial animal : allAnimals)  {
            for (IAnimalSocial friend : animal.getFriends()) {
                Assert.assertTrue("A is not friend of himself.", ! friend.isFriendOf(friend));
            }
        }
    }
}