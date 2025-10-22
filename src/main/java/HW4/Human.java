package HW4;

import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int age;
    private int iq;
//    private Pet pet;
//    private Human mother;
//    private Human father;
    private String[][] schedule;
    private Family family;

    public Human (String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Human (String name, String surname, int age, int iq) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        if (iq < 0) {
            this.iq = 0;
        } else if (iq > 100) {
            this.iq = 100;
        } else this.iq = iq;
//        this.father = father;
//        this.mother = mother;
    }
    public Human (String name, String surname, int age, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        if (iq < 0) {
            this.iq = 0;
        } else if (iq > 100) {
            this.iq = 100;
        } else this.iq = iq;
//        this.pet = pet;
//        this.father = father;
//        this.mother = mother;
        this.schedule = schedule;
    }
    public Human () {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getIq() {
        return iq;
    }
    public void setIq(int iq) {
        if (iq < 0) {
            this.iq = 0;
        } else if (iq > 100) {
            this.iq = 100;
        } else this.iq = iq;
    }

//    public Pet getPet() {
//        return pet;
//    }
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }

//    public Human getMother() {
//        return mother;
//    }
//    public void setMother(Human mother) {
//        this.mother = mother;
//    }

//    public Human getFather() {
//        return father;
//    }
//    public void setFather(Human father) {
//        this.father = father;
//    }

    public String[][] getSchedule() {
        return schedule;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    void greetPet () {
        System.out.printf("Hi, %s", this.getFamily().getPet().getNickname());
    }
    void describePet () {
        System.out.printf("I have a %s, it is %d year(s) old, it is %s!\n", this.getFamily().getPet().getSpecies(), this.getFamily().getPet().getAge(), this.getFamily().getPet().getTrickLevel() > 50 ? "too tricky": "almost not tricky");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + age +
                ", iq=" + iq +
                ", schedule=" + Arrays.toString(schedule) +
//                ", mother=" + this.getFamily().getMother() +
//                ", father=" + this.getFamily().getFather() +
//                ", pet=" + this.getFamily().getPet() +
                '}';
    }
}
