package HW8.human;

import HW8.pet.Pet;

import java.time.LocalDate;
import java.util.HashMap;

public final class Woman extends Human {
    public Woman(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public Woman() {
    }

    public Woman(String name, String surname, LocalDate birthDate, int iq, HashMap<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet(Pet pet) {
        System.out.printf("Hi, %s! You are so nice!\n", this.getFamily().getPet(pet).getNickname());
    }

    void makeup() {
        System.out.println("I look so good!");
    }

}
