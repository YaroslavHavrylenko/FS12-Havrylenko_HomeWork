package HW8.human;

import HW8.pet.Pet;

import java.time.LocalDate;
import java.util.HashMap;

public final class Man extends Human {
    public Man(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, LocalDate birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, String birthDate, int iq)  {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, LocalDate birthDate, int iq, HashMap<String, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
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
