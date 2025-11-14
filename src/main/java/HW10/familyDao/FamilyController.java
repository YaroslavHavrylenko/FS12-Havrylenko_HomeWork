package HW10.familyDao;

import HW10.Family;
import HW10.human.Human;
import HW10.human.Man;
import HW10.human.Woman;
import HW10.pet.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController() {
        this.familyService = new FamilyService();
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int quantity){
        return familyService.getFamiliesBiggerThan(quantity);
    }

    public List<Family> getFamiliesLessThan(int quantity){
        return familyService.getFamiliesLessThan(quantity);
    }

    public int countFamiliesWithFamiliesWithMemberNumber(int quantity) {
        return familyService.countFamiliesWithFamiliesWithMemberNumber(quantity);
    }

    public void createNewFamily(Woman mother, Man father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index){
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String boyName, String girlName) {
        return familyService.bornChild(family, boyName, girlName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int id) {
        return familyService.getFamilyById(id);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}
