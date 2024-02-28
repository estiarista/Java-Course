package org.example;

import java.util.Scanner;

public class ShapeDrawer {
    Scanner scanner= new Scanner(System.in);

    public void drawshape(int choice){
        //Conditional pilih menu
        switch (choice){
            case 1:
                System.out.println("Masukkan berapa tinggi segitiga siku-siku"); //Segitiga siku2
                int triangleHeight = scanner.nextInt();
                drawTriangleSS(triangleHeight);
                break;
            case 2:
                System.out.println("Masukkan berapa tinggi segitiga sama kaki");
                int triangleHeight2 = scanner.nextInt();
                drawTriangleSK(triangleHeight2);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid Input"); //segitiga sama kaki
        }
    }

    public void drawTriangleSS(int triangleHeight){
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

    public void drawTriangleSK(int triangleHeight) {
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

    public void displayMenu(){
        System.out.println("Selamat datang di ASCII gambar!");
        System.out.println("Pilih gambar:");
        System.out.println("1. Segitiga siku-siku"); //nested loop
        System.out.println("2. Segitiga sama kaki"); //nested loop, inner loop ada 2
        System.out.println("3. Exit");
    }

    public void run(){
        //loop while untuk aplikasi terus running sampai ada exit
        while (true){
            displayMenu();
            System.out.println("Masukkan pilihan anda: ");
            int choice = scanner.nextInt();
            drawshape(choice); //Dimana ada conditional
            System.out.println();
        }
    }

    public static void main(String[] args){
        //Inheritance (OOP)
        //Untuk running
        ShapeDrawer drawer = new ShapeDrawer();
        drawer.run();
    }
}