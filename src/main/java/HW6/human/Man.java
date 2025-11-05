package HW6.human;

public class Man extends Human {
    public Man(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Man(String name, String surname, int age, int iq) {
        super(name, surname, age, iq);
    }

    public Man(String name, String surname, int age, int iq, String[][] schedule) {
        super(name, surname, age, iq, schedule);
    }

    public Man() {
    }

    @Override
    void greetPet() {
        System.out.printf("Hi, %s! You are too witty!\n", this.getFamily().getPet().getNickname());
    }

    void repair () {
        System.out.println("My car is ready to run again!");
    }

}
