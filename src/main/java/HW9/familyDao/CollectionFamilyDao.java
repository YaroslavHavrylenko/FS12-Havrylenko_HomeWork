package HW9.familyDao;

import HW9.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    public List<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < familyList.size()) {
            return familyList.get(index);
        } else {
            System.out.printf("Not exist family with index %d!\n", index);
            return null;
        }
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < familyList.size()) {
            familyList.remove(index);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (familyList.contains(family)) {
            familyList.remove(family);
            return true;
        } else return false;
    }

    @Override
    public void saveFamily(Family family) {
        int index = familyList.indexOf(family);

        if (index >= 0) {
            familyList.set(index, family);
        } else {
            familyList.add(family);
        }
    }
}
