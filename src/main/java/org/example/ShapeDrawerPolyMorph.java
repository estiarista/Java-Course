package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;


interface Shape22{ //One of implementation of Polymorphism
    void draw(int height);
}


public class ShapeDrawerPolyMorph {
    Scanner scanner= new Scanner(System.in);

    public void drawshape(int choice){
        switch (choice){
            case 1:
                System.out.println("Enter the height of the triangle:"); //Triangle
                int triangleHeight = scanner.nextInt();
                drawTriangle(triangleHeight);
                break;
            case 2:
                System.out.println("Enter the length of the rectangle:"); //Rectangle
                int rectangleLength = scanner.nextInt();
                System.out.println("Enter the width of the rectangle:"); //Rectangle
                int rectangleWidth = scanner.nextInt();
                drawRectangle(rectangleLength,rectangleWidth);
                break;
            case 3:
                System.out.println("Enter the side of the square:"); //Square
                int squareSisi = scanner.nextInt();
                drawSquare(squareSisi);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    public void drawTriangle(int triangleHeight) {
        for (int i = 1; i <= triangleHeight; i++) {
            for (int j = 1; j <= triangleHeight - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }


    public void drawRectangle(int rectangleLength, int rectangleWidth){
        for (int i=0; i<rectangleLength; i++){
            for (int j=0;j<rectangleWidth; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }


    public void drawSquare(int squareSisi) {
        for (int i = 1; i <= squareSisi; i++) {
            for (int j = 1; j <= squareSisi; j++) {
                if (j == 1 || j == squareSisi || i == 1 || i == squareSisi) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
                System.out.println();
            }
        }



    public void displayMenu(){
        System.out.println("Welcome to ASCII Shape Drawer!");
        System.out.println("Choose a shape to draw:");
        System.out.println("1. Triangle");
        System.out.println("2. Rectangle");
        System.out.println("3. Square");
        System.out.println("4. Exit");
    }

    public void run(){
        while (true){
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            drawshape(choice);
            System.out.println();
        }
    }

    public static void main(String[] args){
        ShapeDrawerPolyMorph drawer = new ShapeDrawerPolyMorph();
        drawer.run();
    }
}