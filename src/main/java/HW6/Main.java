package HW6;

import HW6.human.Human;
import HW6.human.Man;
import HW6.human.Woman;
import HW6.pet.Dog;
import HW6.pet.DomesticCat;


public class Main {
    public static void main(String[] args) {
        String[][] schedule1 = {{DayOfWeek.SUNDAY.name().toLowerCase(), "Walking down the street"}, {DayOfWeek.MONDAY.name().toLowerCase(), "Go to work"}};
        String[][] schedule2 = {{DayOfWeek.FRIDAY.name().toLowerCase(), "Do homework"}, {DayOfWeek.SATURDAY.name().toLowerCase(), "Go to theatre"}};

//        --- FAMILY 1 ---
        Man man1 = new Man("Michael", "Jackson", 45);
        man1.setIq(68);
        Woman woman1 = new Woman("Sandra", "Buloc", 43);
        Family family1 = new Family(woman1, man1);
        System.out.println(family1);
        woman1.setSchedule(schedule1);
        DomesticCat cat = new DomesticCat( "Murzik");
        cat.setAge(1);
        family1.setPet(cat);
        System.out.println(family1);
        Man child1 = new Man("John", "Jackson",1);
        family1.addChild(child1);
        System.out.println(family1);
        Woman child11 = new Woman("Rosa", "Jackson", 2, 32);
        family1.addChild(child11);
        System.out.println(family1);
        family1.getFather().greetPet();
        ((DomesticCat) family1.getPet()).foul();
        family1.getPet().setTrickLevel(50);
        man1.feedPet(false);

        // --- FAMILY 2 ---
        Man man2 = new Man("John", "Travolta",52,48, schedule2);
        Woman woman2 = new Woman("Silvia", "Karson",48, 68,schedule1);
        Family family2 = new Family(woman2,man2);
        Dog dog = new Dog( "Rex", 2, 45, new String[]{"walk", "eat", "sleep"});
        family2.setPet(dog);
        family2.getMother().describePet();
        family2.getMother().greetPet();
        family2.getFather().greetPet();
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
        System.out.println(family2.bornChild());
        System.out.println(family2);

    }
}
