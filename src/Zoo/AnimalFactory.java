package Zoo;

import java.util.Scanner;

public class AnimalFactory {
    private static Zoo zoo;

    public AnimalFactory(Zoo zoo) {
        this.zoo = zoo;
    }

    public static void createAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Enter AnimalID: ");
        int animalID = scanner.nextInt();

        System.out.print("Enter EnclosureID: ");
        int enclosureID = scanner.nextInt();

        boolean isSick = Math.random() < 0.5;

        Animal newAnimal = new Animal(name, age, weight, isSick, color, animalID, enclosureID);


        // Add the new animal to the zoo
        zoo.addAnimal(newAnimal, enclosureID);

        // Update counts and averages in the zoo
        zoo.updateAnimalCount(zoo.getNumAnimals());
        zoo.updateEnclosureCount(zoo.getNumEnclosures());

        if (isSick) {
            zoo.updateSickAnimalCount(zoo.getNumSickAnimals() + 1);
        } else {
            zoo.updateHealthyAnimalCount(zoo.getNumHealthyAnimals() + 1);
        }

        // Display updated statistics
        System.out.println("Animal added successfully!");
        System.out.println("Updated Animal Count: " + zoo.getAnimalCount());
        System.out.println("Updated Enclosure Count: " + zoo.getEnclosureCount());
        System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
        System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());
        System.out.println("Sick Animals: " + zoo.getNumSickAnimals());
        System.out.println("Healthy Animals: " + zoo.getNumHealthyAnimals());
    }

    public static void removeAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter AnimalID to remove: ");
        int animalIDToRemove = scanner.nextInt();

        // Attempt to remove the animal
        boolean removed = zoo.removeAnimal(animalIDToRemove);

        // Print the result
        if (removed) {
            System.out.println("Animal with ID " + animalIDToRemove + " removed successfully!");
        } else {
            System.out.println("Animal with ID " + animalIDToRemove + " not found in the zoo.");
        }

        // Update counts and averages in the zoo
        zoo.updateAnimalCount(zoo.getNumAnimals());
        zoo.updateEnclosureCount(zoo.getNumEnclosures());

        // Display updated statistics
        System.out.println("Updated Animal Count: " + zoo.getAnimalCount());
        System.out.println("Updated Enclosure Count: " + zoo.getEnclosureCount());
        System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
        System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());
        System.out.println("Sick Animals: " + zoo.getNumSickAnimals());
        System.out.println("Healthy Animals: " + zoo.getNumHealthyAnimals());
    }
}