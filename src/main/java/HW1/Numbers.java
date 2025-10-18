package HW1;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random()*101);
        System.out.printf("Random number is - %d\n", randomNumber);
        System.out.println("--- Let the game begin! ---");
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        String stringNumbers = "";

        while (true) {
            System.out.print("Please, enter your number [0...100]: ");
            int yourNumber = scanner.nextInt();
            stringNumbers = stringNumbers.concat(Integer.toString(yourNumber) +",");
            int[] yourNumbersArray = new int[counter];

            if (yourNumber < randomNumber ) {
                System.out.println("Your number is too small. Please, try again.");
//                counter++;
            } else if (yourNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
//                counter++;
            } else {
                System.out.println(stringNumbers);
                System.out.println("Congratulations, Yaroslav!");
                break;
            }
//            yourNumbersArray[counter-1] = yourNumber;
//            System.out.println("Your numbers:" + Arrays.toString(yourNumbersArray));
        }
    }
}
