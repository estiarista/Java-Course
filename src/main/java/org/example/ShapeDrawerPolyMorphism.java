package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collection;
import java.util.AbstractCollection;


interface Shape{ //One of implementation of Polymorphism
    void draw(int height);
}
//
//TriangleSS implements Shape interface
class drawTriangleSS implements Shape{
   @Override //Overriding (Mengganti secara paksa content dari function dalam polymorphism)
    public void draw(int triangleHeight){
        //Nested Loop
        //Outer Loop (Take care the rows)
        for (int i = 1; i <= triangleHeight;i++){
            //Inner Loop (Take care the columns)
            for (int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

//TriangleSK implements Shape interface
class drawTriangleSK implements Shape{
    @Override //Overriding (Mengganti secara paksa content dari function dalam polymorphism)
    public void draw(int triangleHeight) {
        //Nested Loop
        //Outer Loop (Take care the rows)
        for (int i = 1; i <= triangleHeight; i++) {
            //Inner Loop (Take care the columns)
            for (int j = 1; j <= triangleHeight - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class ShapeDrawerPolyMorphism {
    Scanner scanner= new Scanner(System.in);



    public void displayMenu(){
        System.out.println("Selamat datang di ASCII gambar!");
        System.out.println("Pilih gambar:");
        System.out.println("1. Segitiga siku-siku"); //nested loop
        System.out.println("2. Segitiga sama kaki"); //nested loop, inner loop ada 2
        System.out.println("3. Exit");
    }

    public void drawshape(int choice) {
        //Conditional pilih menu
        try {
            switch (choice) {
                case 1:
                    System.out.println("Masukkan berapa tinggi segitiga siku-siku"); //Segitiga siku2
                    int triangleHeight = scanner.nextInt();
                    new drawTriangleSS().draw(triangleHeight);
                    break;
                case 2:
                    System.out.println("Masukkan berapa tinggi segitiga sama kaki");
                    int triangleHeight2 = scanner.nextInt();
                    new drawTriangleSK().draw(triangleHeight2);
                    break;
                case 3:
                    System.exit(0);
                    break;
    //            default:
    //              System.out.println("Invalid Input"); //segitiga sama kaki
            }
        } catch (InputMismatchException ime) {
            System.out.println("Please enter a valid integer.");
            scanner.next(); // to consume the invalid token
        }
    }

    public void run(){
        //loop while untuk aplikasi terus running sampai ada exit
        while (true){
            displayMenu();
            System.out.println("Masukkan pilihan anda: ");
            try {
                int choice = scanner.nextInt();
                drawshape(choice);
                System.out.println();
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a valid integer.");
                scanner.next(); // to consume the invalid token
            }

        }
    }

    public static void main(String[] args){
        //Inheritance (OOP)
        //Untuk running
        ShapeDrawerPolyMorphism drawer = new ShapeDrawerPolyMorphism();
        drawer.run();
    }
}