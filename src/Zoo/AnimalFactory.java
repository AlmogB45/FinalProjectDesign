package Zoo;

import Interfaces.AnimalCreator;
import java.util.Scanner;

public class AnimalFactory {
    private static Zoo zoo;
    private static AnimalCreator animalCreator = new GenericAnimalCreator();

    public AnimalFactory(Zoo zoo) {
        this.zoo = zoo;
    }

    public static void setAnimalCreator(AnimalCreator creator) {
        animalCreator = creator;
    }

    public static void createAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Type (e.g., Elephant): ");
        String type = scanner.nextLine();

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
        scanner.nextLine();

        System.out.print("Enter Enclosure Name: ");
        String enclosureName = scanner.nextLine();

        zoo.setEnclosureName(enclosureID, enclosureName);

        // Provide a random chance for animal to be sick or healthy
        boolean isSick = Math.random() < 0.5;

        Animal newAnimal = animalCreator.createAnimal(type, name, age, weight, isSick, color, animalID, enclosureID);

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

        if (removed) {
            System.out.println("Animal with ID " + animalIDToRemove + " removed successfully!");

            // Update counts and averages in the zoo
            zoo.updateAnimalCount(zoo.getNumAnimals());
            zoo.updateEnclosureCount(zoo.getNumEnclosures());

            // Update counts of sick and healthy animals
            int numSickAnimals = 0;
            int numHealthyAnimals = 0;

            for (Animal animal : zoo.getAnimals()) {
                if (animal.isSick()) {
                    numSickAnimals++;
                } else {
                    numHealthyAnimals++;
                }
            }

            zoo.updateSickAnimalCount(numSickAnimals);
            zoo.updateHealthyAnimalCount(numHealthyAnimals);

            System.out.println("Updated Animal Count: " + zoo.getAnimalCount());
            System.out.println("Updated Enclosure Count: " + zoo.getEnclosureCount());
            System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
            System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());
            System.out.println("Sick Animals: " + zoo.getNumSickAnimals());
            System.out.println("Healthy Animals: " + zoo.getNumHealthyAnimals());
        } else {
            System.out.println("Animal with ID " + animalIDToRemove + " not found in the zoo.");
        }
    }
}