package org.example;

import java.util.Scanner;

class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

// Base class
class Vehicle {
    // Properties
    String brand;
    String model;
    int year;

    // Constructor with InvalidYearException handling
    public Vehicle(String brand, String model, int year) throws InvalidYearException {
        if (year > 2024) {
            throw new InvalidYearException("Invalid year. Year cannot be in the future.");
        }
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method
    void vehicleSound() {
        System.out.println("Generic Vehicle Sound");
    }
}

// Car subclass
class Car extends Vehicle {
    // Additional property
    int numOfDoors;

    // Constructor
    public Car(String brand, String model, int year, int numOfDoors) throws InvalidYearException {
        super(brand, model, year);
        this.numOfDoors = numOfDoors;
    }

    // Override method
    @Override
    void vehicleSound() {
        System.out.println("Vroom Vroom!");
    }
}

// Motorcycle subclass
class Motorcycle extends Vehicle {
    // Additional property
    int hasSidecar;

    // Constructor
    public Motorcycle(String brand2, String model2, int year2, int hasSidecar) throws InvalidYearException {
        super(brand2, model2, year2);
        this.hasSidecar = hasSidecar;
    }

    // Override method
    @Override
    void vehicleSound() {
        System.out.println("Vroom Vroom! (Motorcycle)");
    }
}

// Main class
public class VehiclePolyMorphism {
    // Method to print the sound of any Vehicle
    void printVehicleSound(Vehicle vehicle) {
        vehicle.vehicleSound();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Creating and Printing Car");
            System.out.println("2. Creating and Printing Motorcycle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Input brand of car:");
                        String brand = scanner.next();
                        System.out.println("Input model of car:");
                        String model = scanner.next();
                        System.out.println("Input year of car:");
                        int year = scanner.nextInt();
                        System.out.println("Input number of doors of car:");
                        int numOfDoors = scanner.nextInt();
                        new Car(brand, model, year, numOfDoors).vehicleSound();
                        break;

                    case 2:
                        System.out.println("Input brand of motorcycle:");
                        String brand2 = scanner.next();
                        System.out.println("Input model of motorcycle:");
                        String model2 = scanner.next();
                        System.out.println("Input year of motorcycle:");
                        int year2 = scanner.nextInt();
                        System.out.println("Input has sidecar of motorcycle:");
                        int hasSidecar = scanner.nextInt();
                        new Motorcycle(brand2, model2, year2, hasSidecar).vehicleSound();
                        break;

                    case 3:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InvalidYearException e) {
                // Handle the InvalidYearException
               System.err.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Finally block: Operation complete.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
