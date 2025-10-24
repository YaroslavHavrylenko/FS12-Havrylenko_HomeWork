package HW7.human;

import HW7.pet.Pet;

import java.util.HashMap;

public final class Woman extends Human {
    public Woman(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int age, int iq, HashMap<String, String> schedule) {
        super(name, surname, age, iq, schedule);
    }

    public Woman(String name, String surname, int age, int iq) {
        super(name, surname, age, iq);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hi, %s! You are so nice!\n", this.getFamily().getPet(pet).getNickname());
    }

    void makeup () {
        System.out.println("I look so good!");
    }

}
