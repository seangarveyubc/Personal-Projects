import Exceptions.InvalidInputException;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class Calculator {

    private static Exception InvalidInputException;

    public static void main(String[] args){

        generateUI();


        System.out.println("Welcome to Sean's Calculator Program!");
        int choice = 1;
        Scanner reader = new Scanner(System.in);

        while (choice != 0){
            displayOptions();
            choice = reader.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Thanks for using Sean's Calculator Program!");
                    break;
                case 1: {
                    System.out.println("Please enter 2 numeric values");
                    int a = reader.nextInt();
                    System.out.print("+ ");
                    int b = reader.nextInt();
                    System.out.println("= " + addition(a, b));
                    break;
                }
                case 2: {
                    System.out.println("Please enter 2 numeric values");
                    int a = reader.nextInt();
                    System.out.print("- ");
                    int b = reader.nextInt();
                    System.out.println("= " + subtraction(a, b));
                    break;
                }
                case 3: {
                    System.out.println("Please enter 2 numeric values");
                    int a = reader.nextInt();
                    System.out.print("* ");
                    int b = reader.nextInt();
                    System.out.println("= " + multiply(a, b));
                    break;
                }
                case 4: {
                    double result = 0;
                    while (result == 0) {
                        try {
                            System.out.println("Please enter 2 numeric values");
                            int a = reader.nextInt();
                            System.out.print("/ ");
                            int b = reader.nextInt();
                            System.out.println("result = " + result);
                            result = divide((double)a, (double)b);
                        } catch (Exception InvalidInputException) {
                            System.out.println("Cannot divide by zero, please enter a valid denominator.");
                            System.out.println("result = " + result);
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Please enter a valid operation.");
                }


            }
        }
        reader.close();
    }

    private static void generateUI(){

        //Set JFrame's attributes
        JFrame frame = new JFrame("Sean's Glorious Calculator");
        ImageIcon icon = new ImageIcon("D:\\Personal Projects\\testPrograms_Java\\Calculator\\src\\Images\\WindowIcon.png");
        frame.setIconImage(icon.getImage());

        //Sizing preferences
        Dimension preferredSize = new Dimension(400, 600);
        frame.setSize(preferredSize);
        frame.setResizable(false);

        frame.setVisible(true);
    }

    private static void displayOptions(){
        clearScreen();
        System.out.println("Hello World");
    }

    private static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int addition(int a, int b){
        return a + b;
    }

    private static int subtraction(int a, int b){
        return a - b;
    }

    private static int multiply(int a, int b){
        return a * b;
    }

    private static double divide (double a, double b) throws Exception {
        if (b == 0) {
            throw InvalidInputException;
        }
        System.out.println("a = " + a + " b = " + b);
        return a / b;
    }

}