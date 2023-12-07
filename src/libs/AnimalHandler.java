package libs;

import Zoo.Zoo;
import Zoo.*;



public class AnimalHandler extends Employee {
    private static AnimalHandler instance = new AnimalHandler(getFirstName(), getLastName(), getPhone(), getEmployeeId(),getRole());
    private static final Zoo zoo = Manager.zoo;

    private AnimalHandler(String firstName, String lastName, String phone, int employeeId, String role) {
        super("defaultFirstName", "defaultLastName", "defaultPhone", 0, "defaultRole");
    }

    public static AnimalHandler getInstance() {
        if (instance == null) {
            instance = new AnimalHandler("defaultFirstName", "defaultLastName", "defaultPhone", 0, "defaultRole");
        }
        return instance;
    }

    public static void feedAnimal(int animalID, int enclosureID) {
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        // Check if the specified animal exists in the specified enclosure
        boolean animalFound = false;
        String animalType = "";
        String animalName = "";
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getAnimalID() == animalID && animal.getEnclosureID() == enclosureID) {
                animalFound = true;
                animalName = animal.getName();
                animalType = animal.getType();

                // Perform feeding action here (if needed)

                // Display a message indicating that the animal was fed successfully
                System.out.println("Animal: " + animalName + " from type: " + animalType + " with ID: " + animalID + " in Enclosure: " + enclosureID + " fed successfully!");

                // Break out of the loop once the animal is found and fed
                break;
            }
        }

        // If the animal is not found
        if (!animalFound) {
            System.out.println("Error: Animal with ID " + animalID + " not found in Enclosure " + enclosureID + ".");
        }
    }

    public static void feedEnclosure(int enclosureID) {
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        // Check if the specified enclosure exists
        if (zoo.getAnimalsInEnclosure(enclosureID) == 0) {
            System.out.println("Error: Enclosure with ID " + enclosureID + " does not exist or is empty.");
            return;
        }

        // Feed all animals in the specified enclosure using feedAnimal method
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getEnclosureID() == enclosureID) {
                // Perform feeding action here (if needed)
                feedAnimal(animal.getAnimalID(), enclosureID);
            }
        }

        // Display a message indicating that all animals in the enclosure were fed successfully
        System.out.println("\nEnclosure " + enclosureID + " fed successfully!");

        // Display updated statistics after feeding
        viewZooStat();
    }




    public static void viewZooStat() {
    }



}
