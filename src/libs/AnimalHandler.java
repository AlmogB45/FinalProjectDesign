package libs;

import Zoo.Zoo;
import Zoo.*;



public class AnimalHandler extends Employee {
    private static final Zoo zoo = Manager.zoo;

    public AnimalHandler(String firstName, String lastName, String phone, int employeeId, String role) {
        super(firstName, lastName, phone, employeeId, role);
    }

    public static void feedAnimal(int animalID, int enclosureID) { //TODO Create EnclosureID in Zoo, and add it to Manager.viewZooStats, AnimalHandler, and Maybe ZooBuild
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        // Check if the specified enclosure exists
        if (enclosureID >= zoo.getNumEnclosures() || zoo.getAnimalsInEnclosure(enclosureID) == 0) {
            System.out.println("Error: Enclosure with ID " + enclosureID + " does not exist or is empty.");
            return;
        }

        // Check if the specified animal exists in the specified enclosure
        boolean animalFound = false;
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getAnimalID() == animalID && animal.getEnclosureID() == enclosureID) {
                animalFound = true;
                // Perform feeding action here if needed
                // ...

                // Update the count for the fed animal
                // ...

                System.out.println("Animal with ID " + animalID + " in Enclosure " + enclosureID + " fed successfully!");
                break;
            }
        }

        // If the animal is not found
        if (!animalFound) {
            System.out.println("Error: Animal with ID " + animalID + " not found in Enclosure " + enclosureID + ".");
        }

        // Display updated statistics after feeding
        viewZooStat();
    }

    public void feedEnclosure(int enclosureID) { //TODO Fix method, same as feedAnimal (EnclosureID)
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        // Check if the specified enclosure exists
        if (enclosureID >= zoo.getNumEnclosures() || zoo.getAnimalsInEnclosure(enclosureID) == 0) {
            System.out.println("Error: Enclosure with ID " + enclosureID + " does not exist or is empty.");
            return;
        }

        // Feed all animals in the specified enclosure
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getEnclosureID() == enclosureID) {
                // Perform feeding action here if needed
                // ...
                // Update the count for the fed animal
                // ...
                System.out.println("Animal with ID " + animal.getAnimalID() + " in Enclosure " + enclosureID + " fed successfully!");
            }
        }

        // Display updated statistics after feeding
        viewZooStat();
    }


    public static void viewZooStat() {
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        System.out.println("Zoo Overview:");
        System.out.println("Number of Existing Animals: " + zoo.getNumAnimals());
        System.out.println("Number of Enclosures: " + zoo.getNumEnclosures());
        System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
        System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());

        // Display number of animals in each enclosure
        System.out.println("\nNumber of Animals in Each Enclosure:");
        for (int enclosureId = 0; enclosureId < zoo.getNumEnclosures(); enclosureId++) {
            int animalsInEnclosure = zoo.getAnimalsInEnclosure(enclosureId);
            System.out.println("Enclosure " + enclosureId + ": " + animalsInEnclosure + " animals");
        }

        // Display number of sick and healthy animals
        System.out.println("\nNumber of Sick and Healthy Animals:");
        int numSickAnimals = zoo.getNumSickAnimals();
        int numHealthyAnimals = zoo.getNumAnimals() - numSickAnimals;
        System.out.println("Sick Animals: " + numSickAnimals);
        System.out.println("Healthy Animals: " + numHealthyAnimals);
    }

}
