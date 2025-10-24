package HW7;

import HW7.human.Human;
import HW7.human.Man;
import HW7.human.Woman;
import HW7.pet.Dog;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FamilyTest {
    @Test
    public void testToStringPositive() {
        String expected = "Dog{nickname='Rock', age=5, trickLevel=75, habits=[sleep, eat, drink]}";
        HashSet<String> dogHabits = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        Dog dog = new Dog("Rock", 5, 75, dogHabits);
        String real = dog.toString();
        assertEquals(expected, real);
    }

    @Test
    public void testToStringNegative() {
        String expected = "DOG{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
        HashSet<String> dogHabits = new HashSet<>(Arrays.asList("eat", "drink", "sleep"));
        Dog dog = new Dog("Rock", 5, 75, dogHabits);
        String real = dog.toString();
        assertNotEquals(expected, real);
    }

    @Test
    public void testDeleteChildByHumanPositive() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(child);
        System.out.println(family);
        List<Human> expChildren = new ArrayList<Human>(Collections.singleton(child1));
        List<Human> realChildren = family.getChildren();
        assertEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByHumanNegative() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        Man strangerChild = new Man("Tom", "Hagen", 1975);
        boolean result = family.deleteChild(strangerChild);
        assertFalse(result);
        List<Human> expectedChildren = new ArrayList<Human>();
        expectedChildren.add(child);
        expectedChildren.add(child1);
        List<Human> actualChildren = family.getChildren();
        assertEquals(expectedChildren, actualChildren);
    }

    @Test
    public void testDeleteChildByIndexPositive() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(0);
        List<Human> expChildren = new ArrayList<Human>(Collections.singleton(child1));
        List<Human> realChildren = family.getChildren();
        assertEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByIndexNegative() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        family.deleteChild(3);
        List<Human> expChildren = new ArrayList<>(Arrays.asList(child, child1));
        List<Human> realChildren = family.getChildren();
        assertEquals(expChildren, realChildren);
    }

    @Test
    public void testAddChild() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        List<Human> realChildren = family.getChildren();
        assertEquals(1, realChildren.size());
        assertEquals(child, family.getChildren().get(0));

        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        List<Human> realChildren1 = family.getChildren();

        assertEquals(2, realChildren1.size());
        assertEquals(child1, family.getChildren().get(1));
    }

    @Test
    public void testCountFamilyPositive() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        family.addChild(child);
        assertEquals(3, family.countFamily());

        Human child1 = new Human("Stiven", "Karleone", 1978);
        family.addChild(child1);
        assertEquals(4, family.countFamily());
    }

    @Test
    public void testCountFamilyNegative() {
        Woman mother = new Woman("Jane", "Karleone", 1954);
        Man father = new Man("Vito", "Karleone", 1954);
        Man child = new Man("Michael", "Karleone", 1977);
        Family family = new Family(mother, father);
        assertNotEquals(4, family.countFamily());

        Man child1 = new Man("Stiven", "Karleone", 1978);
        family.addChild(child1);
        assertNotEquals(5, family.countFamily());
    }
}