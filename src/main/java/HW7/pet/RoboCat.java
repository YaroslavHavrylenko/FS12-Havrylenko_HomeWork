package HW7.pet;

import java.util.Arrays;
import java.util.HashSet;

public class RoboCat extends Pet {
    private Species species;

    public RoboCat (String nickname) {
        super(nickname);
        this.species = Species.ROBOCAT;
    }

    public RoboCat (String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBOCAT;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void respond() {
        System.out.println("I`m a cat, I`m a cat, I`m a robo-cat!");
    }

    @Override
    public String toString() {
        return this.getSpecies() + "{" +
                "nickname='" + this.getNickname() + '\'' +
                (this.getAge() == 0 ? "" : ", age=" + this.getAge()) +
                (this.getTrickLevel() == 0 ? "" : ", trickLevel=" + this.getTrickLevel()) +
                (this.getHabits() == null ? "" : ", habits=" + this.getHabits()) +
                '}';
    }
}
