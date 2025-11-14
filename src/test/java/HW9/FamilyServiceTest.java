package HW9;

import HW9.familyDao.FamilyService;
import HW9.human.Human;
import HW9.human.Man;
import HW9.human.Woman;
import HW9.pet.Dog;
import HW9.pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    private FamilyService familyService;

    @BeforeEach
    void setUp() {
        familyService = new FamilyService();
    }

    @Test
    void testCreateNewFamily() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.of(1990, 1, 1));
        Man father = new Man("Bob", "Adams", LocalDate.of(1988, 5, 10));

        familyService.createNewFamily(mother, father);
        Family expectedFamily = familyService.getFamilyById(0);

        assertEquals(1, familyService.count());
        Family family = new Family(mother, father);
        assertEquals(expectedFamily, family);
    }

    @Test
    void testDeleteFamilyByIndex() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());

        familyService.createNewFamily(mother, father);

        assertTrue(familyService.deleteFamilyByIndex(0));
        assertEquals(0, familyService.count());
    }

    @Test
    void testGetFamiliesBiggerThan() {
        Family family1 = new Family(new Woman("Rosa", "Chicone", LocalDate.of(1978, 12, 13)), new Man("Kruse", "Chicone", LocalDate.of(1977, 10, 9)));
        Family family2 = new Family(new Woman("Christina", "Aguilera", LocalDate.of(1981, 4, 18)), new Man("Michael", "Duglas", LocalDate.of(1980, 10, 7)));

        family2.bornChild();

        familyService.getAllFamilies().add(family1);
        familyService.getAllFamilies().add(family2);

        List<Family> result = familyService.getFamiliesBiggerThan(2);
        assertEquals(1, result.size());
        assertEquals(family2, result.getFirst());
    }

    @Test
    void testGetFamiliesLessThan() {
        Family family1 = new Family(new Woman("Rosa", "Chicone", LocalDate.of(1978, 12, 13)), new Man("Kruse", "Chicone", LocalDate.of(1977, 10, 9)));
        Family family2 = new Family(new Woman("Christina", "Aguilera", LocalDate.of(1981, 4, 18)), new Man("Michael", "Duglas", LocalDate.of(1980, 10, 7)));

        family2.bornChild();

        familyService.getAllFamilies().add(family1);
        familyService.getAllFamilies().add(family2);

        List<Family> result = familyService.getFamiliesLessThan(3);
        assertEquals(1, result.size());
        assertEquals(family1, result.getFirst());
    }

    @Test
    void testCountFamiliesWithMemberNumber() {
        Family family1 = new Family(new Woman(), new Man());
        Family family2 = new Family(new Woman(), new Man());
        family2.addChild(new Human());

        familyService.getAllFamilies().add(family1);
        familyService.getAllFamilies().add(family2);

        assertEquals(1, familyService.countFamiliesWithFamiliesWithMemberNumber(2));
    }

    @Test
    void testBornChild() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());

        Family family = new Family(mother, father);
        familyService.getAllFamilies().add(family);

        Family updated = familyService.bornChild(family, "Mike", "Emma");

        assertEquals(3, updated.countFamily());
        assertEquals(father.getSurname(), updated.getChildren().getFirst().getSurname());
    }

    @Test
    void testAdoptChild() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());

        Family family = new Family(mother, father);
        familyService.getAllFamilies().add(family);

        Human child = new Human("Kid", "Smith", LocalDate.now());
        Family updatedFamily = familyService.adoptChild(family, child);

        assertEquals(3, updatedFamily.countFamily());
        assertEquals(family, child.getFamily());
    }

    @Test
    void testDeleteAllChildrenOlderThen() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());
        familyService.createNewFamily(mother, father);
        Family family = familyService.getFamilyById(0);

        Human child1 = new Human("First", "Adams", LocalDate.now().minusYears(20));
        Human child2 = new Human("Second", "Adams", LocalDate.now().minusYears(5));

        family.addChild(child1);
        family.addChild(child2);

        familyService.deleteAllChildrenOlderThen(18);

        assertEquals(1, family.getChildren().size());
        assertEquals("Second", family.getChildren().getFirst().getName());
    }

    @Test
    void testAddPet() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());
        Family family = new Family(mother, father);

        familyService.getAllFamilies().add(family);

        Dog dog = new Dog("Doggo", 3, 40, Set.of("run"));

        familyService.addPet(0, dog);

        Set<Pet> pets = familyService.getPets(0);
        assertEquals(1, pets.size());
        assertTrue(pets.contains(dog));
    }

    @Test
    void testAddPetToExistingSet() {
        Woman mother = new Woman("Anna", "Adams", LocalDate.now());
        Man father = new Man("Bob", "Adams", LocalDate.now());
        Family family = new Family(mother, father);

        Dog dog1 = new Dog("Rex", 2, 35, Set.of("run"));
        HashSet<Pet> pets = new HashSet<>();
        pets.add(dog1);
        family.setPets(pets);

        familyService.getAllFamilies().add(family);

        Dog dog2 = new Dog("Bruno", 4, 42, Set.of("eat"));
        familyService.addPet(0, dog2);

        assertEquals(2, familyService.getPets(0).size());
        assertEquals(true, familyService.getPets(0).contains(dog2));
    }
}
