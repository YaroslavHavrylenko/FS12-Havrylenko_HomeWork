package HW1;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random()*101);
        System.out.printf("Random number is - %d\n", randomNumber);
        System.out.println("--- Let the game begin! ---");
        Scanner scanner = new Scanner(System.in);
        String stringNumbers = "";

        while (true) {
            System.out.print("Please, enter your number [0...100]: ");
            int yourNumber = scanner.nextInt();

            if (yourNumber < randomNumber ) {
                System.out.println("Your number is too small. Please, try again.");
                stringNumbers = stringNumbers.concat(yourNumber +",");
            } else if (yourNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
                stringNumbers = stringNumbers.concat(yourNumber +",");
            } else {
                stringNumbers = stringNumbers.concat(Integer.toString(yourNumber));
                String[] arrayOfStringNumbers = (stringNumbers.split(","));
                int[] yourNumbersArray = new int[arrayOfStringNumbers.length];
                for(int i = 0;i < arrayOfStringNumbers.length;i++) yourNumbersArray[i] = Integer.parseInt(arrayOfStringNumbers[i]);

                Arrays.sort(yourNumbersArray);
                System.out.println("Your numbers is: " + Arrays.toString(yourNumbersArray));
                System.out.println("Congratulations, Yaroslav!");
                break;
            }
        }
    }
}
