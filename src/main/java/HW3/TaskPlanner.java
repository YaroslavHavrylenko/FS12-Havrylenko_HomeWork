package HW3;

import java.util.Scanner;

public class TaskPlanner {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "Do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "Go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "Paint the picture";
        schedule[3][0] = "Thursday";
        schedule[3][1] = "Take a courses";
        schedule[4][0] = "Wednesday";
        schedule[4][1] = "Go to the disco";
        schedule[5][0] = "Friday";
        schedule[5][1] = "Visit a party";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "Do repair";

        Scanner scanner = new Scanner((System.in));
        System.out.println(" --- HW3 - Task planner ---");
        String answer;


        do {
            System.out.print("Please, input the day of the week: ");
            answer = scanner.nextLine();

            String[] answerArray = answer.toLowerCase().split(" ");

            if (answerArray[0].equals("change") || answerArray[0].equals("reschedule")) {
                changeDayOfTheWeek (answerArray[1], schedule);
            } else {
                switch (answer.toLowerCase()) {
                    case ("sunday"): {
                        System.out.printf("Your tasks for Sunday: %s\n", schedule[0][1]);
                        break;
                    }
                    case ("monday"): {
                        System.out.printf("Your tasks for Monday: %s\n", schedule[1][1]);
                        break;
                    }
                    case ("tuesday"): {
                        System.out.printf("Your tasks for Tuesday: %s\n", schedule[2][1]);
                        break;
                    }
                    case ("thursday"): {
                        System.out.printf("Your tasks for Thursday: %s\n", schedule[3][1]);
                        break;
                    }
                    case ("wednesday"): {
                        System.out.printf("Your tasks for Wednesday: %s\n", schedule[4][1]);
                        break;
                    }
                    case ("friday"): {
                        System.out.printf("Your tasks for Friday: %s\n", schedule[5][1]);
                        break;
                    }
                    case ("saturday"): {
                        System.out.printf("Your tasks for Saturday: %s\n", schedule[6][1]);
                        break;
                    }
                    default: {
                        if (!answer.equals("exit")) System.out.println("Sorry, I don't understand you, please try again.");
                        break;
                    }
                }
            }
        } while (!answer.equals("exit"));
    }
    public static void changeDayOfTheWeek (String dayOfWeek, String[][] schedule) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please reschedule your task for %s: ", dayOfWeek.trim());
        String newTask = scanner.nextLine();
        switch (dayOfWeek.toLowerCase()) {
            case ("sunday"): {
                schedule[0][1] = newTask;
                break;
            }
            case ("monday"): {
                schedule[1][1] = newTask;
                break;
            }
            case ("tuesday"): {
                schedule[2][1] = newTask;
                break;
            }
            case ("thursday"): {
                schedule[3][1] = newTask;
                break;
            }
            case ("wednesday"): {
                schedule[4][1] = newTask;
                break;
            }
            case ("friday"): {
                schedule[5][1] = newTask;
                break;
            }
            case ("saturday"): {
                schedule[6][1] = newTask;
                break;
            }
            default: {
                System.out.printf("--- Day of week %s doesn't exist!!! ---\n", dayOfWeek.toUpperCase());
                break;
            }
        }
    }
}
