package HW2;

import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {
        int axisY = (int) (Math.random() * 5);
        int axisX = (int) (Math.random() * 5);
        String[][] shootingAria = {{" - ", " - ", " - ", " - ", " - "},
                {" - ", " - ", " - ", " - ", " - "},
                {" - ", " - ", " - ", " - ", " - "},
                {" - ", " - ", " - ", " - ", " - "},
                {" - ", " - ", " - ", " - ", " - "}};
        shootingAria[axisY][axisX] = " X ";

        renderShootingAria(shootingAria);

        System.out.println("--- All Set. Get ready to rumble! ---");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Please enter shooting row: ");
            String shootingRow = scanner.nextLine();
            while (true) {
                if (shootingRow.matches("-?\\d+")) {
                    int shootY = Integer.parseInt(shootingRow);
                    if (shootY >= 1 && shootY <= 5) {
                        System.out.printf("Постріл ряд %d\n", shootY);
                        break;
                    } else {
                        System.out.print("Your shoot out of range.\nPlease enter shooting row, again: ");
                        shootingRow = scanner.nextLine();
                    }
                } else {
                    System.out.print("Your shoot is not a number.\nPlease enter shooting row, again: ");
                    shootingRow = scanner.nextLine();
                }
            }

            System.out.print("Please enter shooting colum: ");
            String shootingColum = scanner.nextLine();
            while (true) {
                if (shootingColum.matches("-?\\d+")) {
                    int shootX = Integer.parseInt(shootingColum);
                    if (shootX >= 1 && shootX <= 5) {
                        System.out.printf("Постріл колонка %d\n", shootX);
                        break;
                    } else {
                        System.out.print("Your shoot out of range.\nPlease enter shooting colum, again: ");
                        shootingColum = scanner.nextLine();
                    }
                } else {
                    System.out.print("Your shoot is not a number.\nPlease enter shooting colum, again: ");
                    shootingColum = scanner.nextLine();
                }
            }

            int shootY = Integer.parseInt(shootingRow) - 1;
            int shootX = Integer.parseInt(shootingColum) - 1;
            if (axisY == shootY && axisY == shootX) {
                shootingAria[axisY][axisX] = " X ";
                renderShootingAria(shootingAria);
                break;
            } else {
                shootingAria[shootY][shootX] = " * ";
                renderShootingAria(shootingAria);
            }
        }
    }

    public static void renderShootingAria(String[][] aria) {
        System.out.println("--Your shooting aria--");
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 0; i < aria.length; i++) {
            StringBuilder stringShootingRow = new StringBuilder((i + 1) + " |");
            for (int j = 0; j < aria.length; j++) {
                stringShootingRow.append(aria[i][j]).append("|");
            }
            System.out.println(stringShootingRow);
        }
    }
}
