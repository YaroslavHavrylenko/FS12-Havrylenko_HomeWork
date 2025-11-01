package HW5;

import HW5.pet.Pet;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }
//    public void setChildren(Human[] children) {
//        this.children = children;
//        for (int i = 0; i < children.length; i++){
//            this.children[i].setFamily(this);
//        }
//    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        child.setFamily(this);
        Human[] childrenHelper = Arrays.copyOf(this.children, this.children.length + 1);
        childrenHelper[this.children.length] = child;
        this.children = childrenHelper;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            System.out.printf("Children with index - %d out of range!\n", index);
            return false;
        }
        Human[] childrenHelper = new Human[children.length - 1];
        int n = 0;
        for (int i = 0; i < children.length; i++) {
            if (i == index) {
                continue;
            }
            childrenHelper[n++] = children[i];
        }

        children = childrenHelper;
        return true;
    }

    public boolean deleteChild(Human child) {
        int index = -1;

        for (int i = 0; i < children.length; i++) {
            if (children[i].hashCode() == child.hashCode() && children[i].equals(child)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.printf("Child %s %s not a member of family!\n", child.getName(), child.getSurname());
            return false;
        }

        Human[] childrenHelper = new Human[children.length - 1];
        int n = 0;
        for (int i = 0; i < children.length; i++) {
            if (i == index) continue;
            childrenHelper[n++] = children[i];
        }

        children = childrenHelper;
        return true;
    }

    public int countFamily() {
        return 2 + children.length;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + (children.length == 0 ? "no children" : Arrays.toString(children)) +
                ", pet=" + (pet == null ? "no pet" : pet) +
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
        return Objects.hash(getMother(), getFather(), Arrays.hashCode(getChildren()));
    }
}
