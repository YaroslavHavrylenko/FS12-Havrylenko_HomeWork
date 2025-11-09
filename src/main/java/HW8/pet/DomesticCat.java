package HW8.pet;

import java.util.HashSet;

public class DomesticCat extends Pet implements Foul{
    private Species species;

    public DomesticCat (String nickname) {
        super(nickname);
        this.species = Species.DOMESTICCAT;
    }

    public DomesticCat (String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTICCAT;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void respond() {
        System.out.printf("Murr, Murr! %s, love milk!\n", this.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("Cat need to cover my tracks well...");
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
