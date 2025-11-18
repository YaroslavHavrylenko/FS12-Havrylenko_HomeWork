package HW10;

public class Menu {
    public static void renderMenu() {
        System.out.println("            Menu\n" +
                "1. Fill DB test data\n" +
                "2. Display list of families" +
                "3. Display list of families which have members more then __\n" +
                "4. Display list of families which have members less then __\n" +
                "5. Count number of families which have members equals to __\n" +
                "6. Create new family\n" +
                "7. Delete family from list by ID\n" +
                "8. Edit family from list by ID\n" +
                "9. Delete all children older then __\n" +
                "10. Exit\n" +
                "___________________________________________________");
    }
    public static void renderEditFamilyMenu() {
        System.out.println("              Menu\n" +
                "  1. Born child\n" +
                "  2. Adopt child");
    }
}
