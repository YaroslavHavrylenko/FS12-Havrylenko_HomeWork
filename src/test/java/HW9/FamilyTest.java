package HW9;

import HW9.human.Human;
import HW9.human.Man;
import HW9.human.Woman;
import HW9.pet.Dog;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class FamilyTest {
    private Family family;
    private Woman mother;
    private Man father;
    private Man child;
    private Man child1;

    @BeforeEach
    public void setUp() {
        mother = new Woman("Jane", "Karleone", LocalDate.of(1954, 10, 27));
        father = new Man("Vito", "Karleone", LocalDate.of(1954, 4, 16));
        family = new Family(mother, father);
        child = new Man("Michael", "Karleone", LocalDate.of(1977, 2, 10));
        child1 = new Man("Stiven", "Karleone", LocalDate.of(1978, 7, 29));
    }


    @Test
    public void testToStringPositive() {
        String expected = "Dog{nickname='Rock', age=5, trickLevel=75, habits=[sleep, eat, drink]}";
        Set<String> dogHabits = Set.of("eat", "drink", "sleep");
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
        family.addChild(child);
        family.addChild(child1);
        family.deleteChild(child);
        System.out.println(family);
        List<Human> expChildren = new ArrayList<Human>(Collections.singleton(child1));
        List<Human> realChildren = family.getChildren();
        Assertions.assertEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByHumanNegative() {
        family.addChild(child);
        family.addChild(child1);
        Man strangerChild = new Man("Tom", "Hagen", LocalDate.of(1975, 12, 12));
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
        family.addChild(child);
        family.addChild(child1);
        family.deleteChild(0);
        List<Human> expChildren = new ArrayList<Human>(Collections.singleton(child1));
        List<Human> realChildren = family.getChildren();
        assertEquals(expChildren, realChildren);
    }

    @Test
    public void testDeleteChildByIndexNegative() {
        family.addChild(child);
        family.addChild(child1);
        family.deleteChild(3);
        List<Human> expChildren = new ArrayList<>(Arrays.asList(child, child1));
        List<Human> realChildren = family.getChildren();
        assertEquals(expChildren, realChildren);
    }

    @Test
    public void testAddChild() {
        family.addChild(child);
        List<Human> realChildren = family.getChildren();
        assertEquals(1, realChildren.size());
        assertEquals(child, family.getChildren().get(0));

        family.addChild(child1);
        List<Human> realChildren1 = family.getChildren();

        assertEquals(2, realChildren1.size());
        assertEquals(child1, family.getChildren().get(1));
    }

    @Test
    public void testCountFamilyPositive() {
        family.addChild(child);
        assertEquals(3, family.countFamily());

        family.addChild(child1);
        assertEquals(4, family.countFamily());
    }

    @Test
    public void testCountFamilyNegative() {
        assertNotEquals(4, family.countFamily());

        family.addChild(child1);
        assertNotEquals(5, family.countFamily());
    }
}