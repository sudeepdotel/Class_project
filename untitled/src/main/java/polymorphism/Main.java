package polymorphism;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculation calculation = new Calculation();

        System.out.println("What you want to calculate ? \n1 for circle\n2 for triangle\n3 for square\n4 for rectangle\n0 to exit");

        int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    //calculate circle
                    System.out.println("Enter radius(floating point) to calculate area of circle :");
                    float circle = scanner.nextFloat();
                    System.out.println(calculation.calculate(circle));
                    break;
                case 2:
                    //calculate triangle
                    System.out.println("Enter base (floating value) :");
                    float base = scanner.nextFloat();
                    System.out.println("Enter height (floating value) :");
                    float height = scanner.nextFloat();
                    System.out.println(calculation.calculate(base, height));
                    break;
                case 3:
                    //calculate square
                    System.out.println("Enter side(int) to calculate area of square:");
                    int square = scanner.nextInt();
                    System.out.println(calculation.calculate(square));
                    break;
                case 4:
                    //calculate rectangle
                    System.out.println("Enter length (double)");
                    double len = scanner.nextDouble();
                    System.out.println("Enter width (double");
                    double wid = scanner.nextDouble();
                    System.out.println(calculation.calculate(len, wid));
                    break;
                case 0:
                    System.out.println("Thank you for using my application to calculate area!!");
                    break;
                default:
                    System.out.println("Done");
            }


    }
}
