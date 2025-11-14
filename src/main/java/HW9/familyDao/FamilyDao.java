package HW9.familyDao;

import HW9.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex (int index);
    boolean deleteFamily (int index);
    boolean deleteFamily (Family family);
    void saveFamily (Family family);
}
