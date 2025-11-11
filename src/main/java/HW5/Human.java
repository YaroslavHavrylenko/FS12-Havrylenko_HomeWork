package HW5;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int age;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Human(String name, String surname, int age, int iq) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.iq = iqVerification(iq);
    }

    public Human(String name, String surname, int age, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.iq = iqVerification(iq);
        this.schedule = schedule;
    }

    public Human() {
    }

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
        this.iq = iqVerification(iq);
    }

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

    void greetPet() {
        System.out.printf("Hi, %s\n", this.getFamily().getPet().getNickname());
    }

    void describePet() {
        System.out.printf("I have a %s, it is %d year(s) old, it is %s!\n", this.getFamily().getPet().getSpecies(), this.getFamily().getPet().getAge(), this.getFamily().getPet().getTrickLevel() > 50 ? "too tricky" : "almost not tricky");
    }

    public boolean feedPet(boolean isTimeToEat) {
        if (isTimeToEat) {
            System.out.printf("Hm... I feed my %s!\n", family.getPet().getNickname());
            return true;
        } else {
            int comparisonTrickLevel = (int) (Math.random() * (100 + 1));
            if (family.getPet().getTrickLevel() >= comparisonTrickLevel) {
                System.out.printf("Hm... I feed my %s!\n", family.getPet().getNickname());
                return true;
            } else {
                System.out.printf("I think, %s not hangry!\n", family.getPet().getNickname());
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + age +
                (iq == 0 ? "" : (", iq=" + iq)) +
                (schedule == null ? "" : ", schedule=" + Arrays.deepToString(schedule)) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() && getIq() == human.getIq() && Objects.equals(getName(), human.getName()) && Objects.equals(getSurname(), human.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getIq());
    }

    private int iqVerification(int iq) {
        if (iq < 0) {
            return this.iq = 0;
        } else return this.iq = Math.min(iq, 100);
    }
}