package HW8.human;

import HW8.Family;
import HW8.pet.Pet;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthDate;
    //    private String birthDateForAdoptChild;
    private int iq;
    private HashMap<String, String> schedule;
    private Family family;

    public Human(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, LocalDate birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iqVerification(iq);
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDateForAdoptChild(birthDate);
        this.iq = iqVerification(iq);
    }

    public Human(String name, String surname, LocalDate birthDate, int iq, HashMap<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iqVerification(iq);
    }

    public HashMap<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet(Pet pet) {
        System.out.printf("Hi, %s\n", this.getFamily().getPet(pet).getNickname());
    }

    public void describePet(Pet pet) {
        System.out.printf("I have a %s, it is %d year(s) old, it is %s!\n", this.getFamily().getPet(pet).getNickname(), this.getFamily().getPet(pet).getAge(), this.getFamily().getPet(pet).getTrickLevel() > 50 ? "too tricky" : "almost not tricky");
    }

    public boolean feedPet(boolean isTimeToEat, Pet pet) {
        if (isTimeToEat) {
            System.out.printf("Hm... I feed my %s!\n", pet.getNickname());
            return true;
        } else {
            int comparisonTrickLevel = (int) (Math.random() * (100 + 1));
            if (pet.getTrickLevel() >= comparisonTrickLevel) {
                System.out.printf("Hm... I feed my %s!\n", pet.getNickname());
                return true;
            } else {
                System.out.printf("I think, %s not hangry!\n", pet.getNickname());
                return false;
            }
        }
    }

    public void describeAge() {
        Period differenceDate = Period.between(getBirthDate(), LocalDate.now());
        System.out.printf("%s %s have %d years, %d months and %d days\n", getName(), getSurname(), differenceDate.getYears(), differenceDate.getMonths(), differenceDate.getDays());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthdayFormat(birthDate) +
                (iq == 0 ? "" : (", iq=" + iq)) +
                (schedule == null ? "" : ", schedule=" + schedule) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return getBirthDate() == human.getBirthDate() && getIq() == human.getIq() && Objects.equals(getName(), human.getName()) && Objects.equals(getSurname(), human.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate(), getIq());
    }

    private int iqVerification(int iq) {
        if (iq < 0) {
            return this.iq = 0;
        } else return this.iq = Math.min(iq, 100);
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate birthDateForAdoptChild(String birthDateStr) {
        return LocalDate.parse(birthDateStr, formatter);
    }

    private String birthdayFormat(LocalDate birthDate) {
        return birthDate.format(formatter);
    }
}
