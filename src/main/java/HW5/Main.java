package HW5;

import HW5.pet.Pet;
import HW5.pet.Species;

public class Main {
    public static void main(String[] args) {
        String[][] schedule1 = {{DayOfWeek.SUNDAY.name().toLowerCase(), "Walking down the street"}, {DayOfWeek.MONDAY.name().toLowerCase(), "Go to work"}};
        String[][] schedule2 = {{DayOfWeek.FRIDAY.name().toLowerCase(), "Do homework"}, {DayOfWeek.SATURDAY.name().toLowerCase(), "Go to theatre"}};

//        --- FAMILY 1 ---
        Human man1 = new Human("Michael", "Jackson", 45);
        man1.setIq(68);
        Human woman1 = new Human("Sandra", "Buloc", 43);
        Family family1 = new Family(woman1, man1);
        System.out.println(family1);
        woman1.setSchedule(schedule1);
        Pet cat = new Pet(Species.CAT, "Murzik");
        cat.setAge(1);
        family1.setPet(cat);
        System.out.println(family1);
        Human child1 = new Human("John", "Jackson",1);
        family1.addChild(child1);
        System.out.println(family1);
        Human child11 = new Human("Rosa", "Jackson", 2, 32);
        family1.addChild(child11);
        System.out.println(family1);
        family1.getFather().greetPet();
        family1.getPet().foul();
        family1.getPet().setTrickLevel(50);
        man1.feedPet(false);

        // --- FAMILY 2 ---
        Human man2 = new Human("John", "Travolta",52,48, schedule2);
        Human woman2 = new Human("Silvia", "Karson",48, 68,schedule1);
        Family family2 = new Family(woman2,man2);
        Pet dog = new Pet(Species.DOG, "Rex", 2, 45, new String[]{"walk", "eat", "sleep"});
        family2.setPet(dog);
        System.out.println(family2);
        Human child2 = new Human("Kristine","Travolta", 2, 68);
        family2.addChild(child2);
        Human child21 = new Human("Rocky","Travolta", 1, 56);
        family2.addChild(child21);
        System.out.println(family2);
        System.out.printf("Family 2 count %d members\n", family2.countFamily());
        family2.deleteChild(child2);
        System.out.printf("Family 2 count %d members\n", family2.countFamily());
        System.out.println(family2);
    }
}
