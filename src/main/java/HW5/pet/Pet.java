package HW5.pet;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet (Species specie, String nickname) {
        this.species = specie;
        this.nickname = nickname;
    }
    public Pet (Species specie, String nickname, int age, int trickLevel, String[] habits) {
        this.species = specie;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet () {}

    public Species getSpecies() {
        return species;
    }
    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }
    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    void eat () {
        System.out.println("I am eating!");
    }
    void respond () {
        System.out.printf("Hi owner! I'm %s! I'm bored!\n", this.nickname);
    }
    public void foul() {
        System.out.println("I need to cover my tracks well...");
    }

    @Override
    public String toString() {
        return getSpecies() + "{" +
                "nickname='" + nickname + '\'' +
                (age == 0 ? "" : ", age=" + age) +
                (trickLevel == 0 ? "" : ", trickLevel=" + trickLevel) +
                (habits == null ? "" : ", habits=" + Arrays.toString(habits)) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return getAge() == pet.getAge() && getTrickLevel() == pet.getTrickLevel() && Objects.equals(getSpecies(), pet.getSpecies()) && Objects.equals(getNickname(), pet.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpecies(), getNickname(), getAge(), getTrickLevel());
    }
}
