package HW10.pet;

import java.util.Set;

public class Fish extends Pet{
    private Species species;

    public Fish (Species specie, String nickname) {
        super(nickname);
        this.species = Species.FISH;
    }

    public Fish (Species specie, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void respond() {
        System.out.println("Bol! Bol! Bol!");
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
