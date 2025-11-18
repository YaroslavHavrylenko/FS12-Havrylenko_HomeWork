package HW10;

import HW10.familyDao.FamilyController;
import HW10.human.Man;
import HW10.human.Woman;
import HW10.pet.Dog;
import HW10.pet.DomesticCat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Application {
    private final FamilyController familyController = new FamilyController();
    private final Scanner scanner = new Scanner(System.in);

    public void runApp() {
        System.out.println("-------Start Happy Family App.--------");
        Menu.renderMenu();
        while (true) {
            System.out.print("Please enter the number of menu: ");
            String menuPoint = scanner.nextLine();
            switch (menuPoint) {
                case "1":
                    createTestData();
                    break;
                case "2":
                    familyController.displayAllFamilies();
                    break;
                case "3":
                    System.out.print("Please enter the number of member family for filter bigger then: ");
                    int numberBiggerOfMemberFamily = scanner.nextInt();
                    familyController.getFamiliesBiggerThan(numberBiggerOfMemberFamily);
                    break;
                case "4":
                    System.out.print("Please enter the number of member family for filter less then: ");
                    int numberLessOfMemberFamily = scanner.nextInt();
                    familyController.getFamiliesLessThan(numberLessOfMemberFamily);
                    break;
                case "5":
                    System.out.print("Please enter the number of member family for filter equals to: ");
                    int numberEqualsOfMemberFamily = scanner.nextInt();
                    familyController.countFamiliesWithFamiliesWithMemberNumber(numberEqualsOfMemberFamily);
                    break;
                case "6":
                    createNewFamily();
                    break;
            }
        }
    }

    private void createTestData() {
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
    }

    private void  createNewFamily() {

    }
}
