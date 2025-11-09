package HW7;

import HW7.human.Human;
import HW7.human.Man;
import HW7.human.Woman;
import HW7.pet.Dog;
import HW7.pet.DomesticCat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> schedule1 = new HashMap<>();
        schedule1.put(DayOfWeek.SUNDAY.getTitle(), "Walking down the street");
        schedule1.put(DayOfWeek.MONDAY.getTitle(), "Go to work");
        HashMap<String, String> schedule2 = new HashMap<>();
        schedule2.put(DayOfWeek.FRIDAY.getTitle(), "Do homework");
        schedule2.put(DayOfWeek.SATURDAY.getTitle(), "Go to theatre");

//        --- FAMILY 1 ---
        Man man1 = new Man("Michael", "Jackson", 45);
        man1.setIq(68);
        Woman woman1 = new Woman("Sandra", "Buloc", 43);
        Family family1 = new Family(woman1, man1);
        System.out.println(family1);
        woman1.setSchedule(schedule1);
        DomesticCat cat = new DomesticCat("Murzik");
        cat.setAge(1);
        family1.addPet(cat);
        System.out.println(family1);
        Man child1 = new Man("John", "Jackson", 1);
        family1.addChild(child1);
        System.out.println(family1);
        Woman child11 = new Woman("Rosa", "Jackson", 2, 32);
        family1.addChild(child11);
        System.out.println(family1);
        family1.getFather().greetPet(cat);
        ((DomesticCat) family1.getPet(cat)).foul();
        family1.getPet(cat).setTrickLevel(50);
        man1.feedPet(false, cat);

        // --- FAMILY 2 ---
        Man man2 = new Man("John", "Travolta", 52, 48, schedule2);
        Woman woman2 = new Woman("Silvia", "Karson", 48, 68, schedule1);
        Family family2 = new Family(woman2, man2);
        HashSet<String> dogHabits = new HashSet<>();
        dogHabits.add("walk");
        dogHabits.add("eat");
        dogHabits.add("sleep");
        Dog dog = new Dog("Rex", 2, 45, dogHabits);
        family2.addPet(dog);
        family2.getMother().describePet(dog);
        family2.getMother().greetPet(dog);
        family2.getFather().greetPet(dog);
        System.out.println(family2);
        Human child2 = new Human("Kristine", "Travolta", 2, 68);
        family2.addChild(child2);
        Human child21 = new Human("Rocky", "Travolta", 1, 56);
        family2.addChild(child21);
        System.out.println(family2);
        System.out.printf("Family 2 count %d members\n", family2.countFamily());
        family2.deleteChild(child2);
        System.out.printf("Family 2 count %d members\n", family2.countFamily());
        System.out.println(family2);
        System.out.println(family2.bornChild());
        System.out.println(family2);

    }
}
