package HW4;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet (String specie, String nickname) {
        this.species = specie;
        this.nickname = nickname;
    }
    public Pet (String specie, String nickname, int age, int trickLevel, String[] habits) {
        this.species = specie;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet () {};

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
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
        System.out.printf("Hi owner! I'm %s! I'm bored!", this.nickname);
    }
    void foul() {
        System.out.println("I need to cover my tracks well...");
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
