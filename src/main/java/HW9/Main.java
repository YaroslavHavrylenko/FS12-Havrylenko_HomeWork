package HW9;

import HW9.familyDao.FamilyController;
import HW9.human.Man;
import HW9.human.Woman;
import HW9.pet.Dog;
import HW9.pet.DomesticCat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("------Working with DAO------");

        HashMap<String, String> schedule1 = new HashMap<>();
        schedule1.put(DayOfWeek.SUNDAY.getTitle(), "Walking down the street");
        schedule1.put(DayOfWeek.MONDAY.getTitle(), "Go to work");
        HashMap<String, String> schedule2 = new HashMap<>();
        schedule2.put(DayOfWeek.FRIDAY.getTitle(), "Do homework");
        schedule2.put(DayOfWeek.SATURDAY.getTitle(), "Go to theatre");

        //        --- FAMILY 1 ---
        Man man1 = new Man("Michael", "Jackson", LocalDate.of(1981, 10, 25), 68);
        Woman woman1 = new Woman("Sandra", "Buloc", LocalDate.of(1982, 8, 13), 56);
        woman1.setSchedule(schedule1);
        Man child1 = new Man("John", "Jackson", LocalDate.of(2024, 11, 20));
        Woman child11 = new Woman("Rosa", "Jackson", LocalDate.of(2023, 7, 5), 32);

        // --- FAMILY 2 ---
        Man man2 = new Man("John", "Travolta", LocalDate.of(1973, 2, 18), 48, schedule2);
        Woman woman2 = new Woman("Silvia", "Karson", LocalDate.of(1977, 11, 2), 68, schedule1);
        Dog dog = new Dog("Rex", 2, 45, Set.of("walk", "eat", "sleep"));
        DomesticCat cat = new DomesticCat("Murzik");
        cat.setAge(1);
        Woman child2 = new Woman("Kristine", "Travolta", LocalDate.of(2023, 7, 18), 68);
        Man child21 = new Man("Rocky", "Travolta", LocalDate.of(2024, 5, 31), 56);

        Man adoptChild = new Man("Kirk", "Jayson", "20/03/2016", 58);

        //        -------DAO-------

        FamilyController familyController = new FamilyController();
        familyController.displayAllFamilies();
        familyController.createNewFamily(woman1, man1);
        familyController.getFamilyById(0).addChild(child1);
        familyController.getFamilyById(0).addChild(child11);
        familyController.getAllFamilies();
        familyController.displayAllFamilies();

        familyController.createNewFamily(woman2, man2);
        familyController.getFamilyById(1).addChild(child2);
        familyController.getFamilyById(1).addChild(child21);
        familyController.addPet(1, dog);
        familyController.addPet(1, cat);
        familyController.adoptChild(familyController.getFamilyById(1), adoptChild);

        System.out.printf("Total quantity of families - %d.\n", familyController.count());
        familyController.displayAllFamilies();
        System.out.println("Families bigger then 4 members:");
        familyController.getFamiliesBiggerThan(4);
        System.out.println("Families less then 5 members:");
        familyController.getFamiliesLessThan(5);
        System.out.printf("Quantity families with families member 5: %d\n", familyController.countFamiliesWithFamiliesWithMemberNumber(5));
        familyController.deleteFamilyByIndex(0);
        familyController.displayAllFamilies();
        familyController.bornChild(familyController.getFamilyById(0), "Goga", "Rita");
        familyController.displayAllFamilies();
        familyController.deleteAllChildrenOlderThen(2);
        familyController.displayAllFamilies();
        System.out.println("Pets - " + familyController.getPets(0));
    }
}