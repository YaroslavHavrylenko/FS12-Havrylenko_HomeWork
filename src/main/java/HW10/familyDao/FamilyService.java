package HW10.familyDao;

import HW10.Family;
import HW10.human.Human;
import HW10.human.Man;
import HW10.human.Woman;
import HW10.pet.Pet;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService() {
        this.familyDao = new CollectionFamilyDao();
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> familyList = getAllFamilies();
        if (familyList.isEmpty()) {
            System.out.println("No families at family list!");
        } else {
            System.out.println("List of families:");
            familyList.forEach(family -> System.out.println(((familyList.indexOf(family)) + 1) + ") " + family.prettyFormat()));
        }
    }

    public List<Family> getFamiliesBiggerThan(int quantity) {
        List<Family> familyList = getAllFamilies();
        return familyList.stream()
                .filter(family -> family.countFamily() > quantity)
                .peek(family -> System.out.println(((familyList.indexOf(family)) + 1) + ") " + family.prettyFormat()))
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int quantity) {
        List<Family> familyList = getAllFamilies();
        return familyList.stream()
                .filter(family -> family.countFamily() < quantity)
                .peek(family -> System.out.println(((familyList.indexOf(family)) + 1) + ") " + family.prettyFormat()))
                .collect(Collectors.toList());
    }

    public int countFamiliesWithFamiliesWithMemberNumber(int quantity) {
        return (int) getAllFamilies().stream()
                .filter(family -> family.countFamily() == quantity)
                .count();
    }

    public void createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        double rnd = Math.random();
        if (rnd < 0.5) {
            Man boy = new Man(boyName, family.getFather().getSurname(), LocalDate.now());
            family.addChild(boy);
        } else {
            Woman girl = new Woman(girlName, family.getFather().getSurname(), LocalDate.now());
            family.addChild(girl);
        }
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        child.setFamily(family);
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        for (Family family : getAllFamilies()) {
            family.getChildren().removeIf(child ->
                    Period.between(child.getBirthDate(), LocalDate.now()).getYears() >= age
            );
            familyDao.saveFamily(family); // якщо DAO вимагає оновлення
        }
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return familyDao.getFamilyByIndex(id);
    }

    public Set<Pet> getPets(int index) {
        return getFamilyById(index).getPets();
    }

    public void addPet(int index, Pet pet) {
        if (getPets(index) == null){
            HashSet<Pet> pets = new HashSet<>();
            pets.add(pet);
            getFamilyById(index).setPets(pets);
        } else  getPets(index).add(pet);
        familyDao.saveFamily(getFamilyById(index));
    }
}