package HW8.human;

import HW8.pet.Pet;

import java.util.HashMap;

public final class Man extends Human {
    public Man(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Man(String name, String surname, int age, int iq) {
        super(name, surname, age, iq);
    }

    public Man(String name, String surname, int age, int iq, HashMap<String, String> schedule) {
        super(name, surname, age, iq, schedule);
    }

    public Man() {
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hi, %s! You are too witty!\n", this.getFamily().getPet(pet).getNickname());
    }

    void repair () {
        System.out.println("My car is ready to run again!");
    }
}
