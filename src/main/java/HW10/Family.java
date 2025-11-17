package HW10;

import HW10.human.Human;
import HW10.human.HumanCreator;
import HW10.human.Man;
import HW10.human.Woman;
import HW10.pet.Pet;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Family implements HumanCreator {
    private Woman mother;
    private Man father;
    private List<Human> children;
    private HashSet<Pet> pets;

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


    public HashSet<Pet> getPets() {
        return pets;
    }

    public void setPets(HashSet<Pet> pets) {
        this.pets = pets;
    }


    public Pet getPet(Pet pet) {
        if (pets.contains(pet)) {
            System.out.println("Тваринка є");
            return pet;
        } else return null;
    }

    public void addPet(Pet pet) {
        if (this.pets == null) this.pets = new HashSet<Pet>(0);
        this.pets.add(pet);
    }


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

    public String prettyFormat() {
        return "family:\n" +
                "   - mother: " + mother.humanToPrettyFormat() + "\n" +
                "   - father: " + father.humanToPrettyFormat() + "\n" +
                "   - children:\n" + (children.isEmpty() ? "no children" : childrenToPrettyFormat(children)) +
                "   - pets:\n" + ((pets == null || pets.isEmpty()) ? "no pet" : pets.stream()
                .map(Pet::petToPrettyFormat)
                .collect(Collectors.joining()));
    }

    private String childrenToPrettyFormat(List<Human> children) {
        StringBuilder stringOfChildren = new StringBuilder();
        for (Human child : children) {
            if (child instanceof Man) {
                stringOfChildren.append("      boy: ").append(child.humanToPrettyFormat()).append("\n");
            } else {
                stringOfChildren.append("      girl: ").append(child.humanToPrettyFormat()).append("\n");
            }
        }

        return stringOfChildren.toString();
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