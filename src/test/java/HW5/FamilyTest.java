package HW5;

import HW5.pet.Pet;
import HW5.pet.Species;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyTest {
    @Test
    public void testToStringPositive() {
        String expected = "Dog{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
        Pet dog = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        String real = dog.toString();
        assertEquals(expected, real);
    }

    @Test
    public void testToStringNegative() {
        String expected = "DOG{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
        Pet dog = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        String real = dog.toString();
        assertNotEquals(expected, real);
    }

    @Test
    public void testDeleteChildByHumanPositive() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(child);
        Human[] expChildren = new Human[]{child1};
        Human[] realChildren = family.getChildren();
        assertArrayEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByHumanNegative() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        Human strangerChild = new Human("Tom", "Hagen", 1975);
        boolean result = family.deleteChild(strangerChild);
        assertFalse(result);
        Human[] expectedChildren = new Human[]{child, child1};
        Human[] actualChildren = family.getChildren();
        assertArrayEquals(expectedChildren, actualChildren);
    }

    @Test
    public void testDeleteChildByIndex() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(0);
        Human[] expChildren = new Human[]{child1};
        Human[] realChildren = family.getChildren();
        assertArrayEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByWrongIndex() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(5);
        Human[] expChildren = new Human[]{child, child1};
        Human[] realChildren = family.getChildren();
        assertArrayEquals(expChildren, realChildren);
    }

    @Test
    public void testAddChild() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Human[] realChildren = family.getChildren();
        assertEquals(1, realChildren.length);
        assertEquals(child, family.getChildren()[0]);

        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        Human[] realChildren1 = family.getChildren();

        assertEquals(2, realChildren1.length);
        assertEquals(child1, family.getChildren()[1]);
    }

    @Test
    public void testCountFamily() {
        Human mother = new Human("Jane", "Karleone", 1954);
        Human father = new Human("Vito", "Karleone", 1954);
        Human child = new Human("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        assertEquals(3, family.countFamily());

        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        assertEquals(4, family.countFamily());
    }
}