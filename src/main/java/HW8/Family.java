package HW8;

import HW8.human.Human;
import HW8.human.HumanCreator;
import HW8.human.Man;
import HW8.human.Woman;
import HW8.pet.Pet;

import java.time.LocalDate;
import java.util.*;

public class Family implements HumanCreator {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Human>(0);
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Woman getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public Man getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }


    public Set<Pet> getPets() { return pets; }
    public void setPets(Set<Pet> pets) { this.pets = pets; }


    public Pet getPet(Pet pet) {
        if (pets.contains(pet)) {
            System.out.println("Тваринка є");
            return pet;
        } else return null;
//        return null;
    }
    public void addPet(Pet pet) {
        if (this.pets == null) this.pets = new HashSet<Pet>(0);
        this.pets.add(pet); }


    public void addChild(Human child) {
        child.setFamily(this);
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            System.out.printf("Children with index - %d out of range!\n", index);
            return false;
        } else {
            children.get(index).setFamily(null);
            children.remove(children.get(index));
            return true;
        }
    }

    public boolean deleteChild(Human child) {
        if (children.contains(child)) {
            child.setFamily(null);
            children.remove(child);
            return true;
        } else {
            System.out.printf("Children %s %s not exist at this family!\n", child.getName(), child.getSurname());
            return false;

        }
    }

    @Override
    public Human bornChild() {
        double rnd = Math.random();
        if (rnd < 0.5) {
            Woman girl = new Woman(generateName(rnd), this.getFather().getSurname(), LocalDate.now(), (this.getFather().getIq() + this.getMother().getIq()) / 2);
            addChild(girl);
            return girl;
        } else {
            Man boy = new Man(generateName(rnd), this.getFather().getSurname(), LocalDate.now(), (this.getFather().getIq() + this.getMother().getIq() / 2));
            addChild(boy);
            return boy;
        }
    }

    public int countFamily() {
        return 2 + children.size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + (children.isEmpty() ? "no children" : children) +
                ", pet=" + ((pets == null || pets.isEmpty()) ? "no pet" : pets) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(getMother(), family.getMother()) && Objects.equals(getFather(), family.getFather()) && Objects.deepEquals(getChildren(), family.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather(), getChildren());
    }

    private String generateName(double rnd) {
        String[] girlNames = {"Helen", "Silvia", "Sharon", "Ginger", "Lara", "Jessica", "Sara", "Eva"};
        String[] boyNames = {"John", "Romeo", "Kirk", "Robert", "David", "Lionel", "Bob", "Alan"};
        if (rnd < 0.5) {
            return girlNames[(int) (Math.random() * girlNames.length)];
        } else return boyNames[(int) (Math.random() * boyNames.length)];
    }
}