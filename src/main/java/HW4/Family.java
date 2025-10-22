package HW4;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family (Human mother, Human father){
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

    public void addChild (Human child) {
        child.setFamily(this);
        Human[] childrenHelper = Arrays.copyOf(this.children,this.children.length + 1);
        childrenHelper[this.children.length] = child;
        this.children = childrenHelper;
    }
    public void deleteChild (int index) {
        if (index < 0 || index > children.length) {
            System.out.printf("Children with index - %d doesn't exist!\n", index);
        } else {
            Human[] childrenHelper = new Human[children.length - 1];
            for (int i = 0; i < childrenHelper.length; i++){
                if (!(i == index)){
                    childrenHelper[i] = children[i];
                } else {
                    childrenHelper[i] = children[++i];
                }
                childrenHelper[i] = children[i == index? ++i: i];
            }

        }

    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + (children.length == 0 ? "no children": Arrays.toString(children)) +
                ", pet=" + (pet == null? "no pet": pet) +
                '}';
    }
}
