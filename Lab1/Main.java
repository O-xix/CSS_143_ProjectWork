import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public void controlStructures() {
        //1.1
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        //1.2
        int count = 0;
        int num = 0;
        while (count < 10) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
        
        //1.3 & 1.4
        Scanner scannerQuizzes = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter the first 5 integer quiz scores:");

        for (int i = 0; i < 5; i++) {
            int score = scannerQuizzes.nextInt();
            sum += score;
        }

        double average = (double) sum / 5;

        System.out.printf("Sum of the quiz scores: %d%n", sum);
        System.out.printf("Average of the quiz scores: %.2f%n", average);

        scannerQuizzes.close();
        
        //1.5
        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student's score:");

        int score = scanner.nextInt();

        char grade;

        if (score > 90) {
            grade = 'A';
        } else if (score > 80) {
            grade = 'B';
        } else if (score > 70) {
            grade = 'C';
        } else if (score > 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Letter grade: " + grade);

        scanner.close();
        */

        //1.6
        Scanner scannerStudent = new Scanner(System.in);

        System.out.println("Enter the student's score:");

        int score = scannerStudent.nextInt();

        char grade;

        switch (score / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Letter grade (using switch): " + grade);

        scannerStudent.close();
    }
}
