package libs;

import Interfaces.AnimalObserver;
import Zoo.Zoo;
import Zoo.Animal;

public class Veterinarian extends Employee {
    private static final Zoo zoo = Manager.zoo;

    public Veterinarian(String firstName, String lastName, String phone, int employeeId, String role) {
        super(firstName, lastName, phone, employeeId, role);
    }

    public static void treatAnimal(int animalID, int enclosureID) {
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

                // Perform treatment action here
                if (animal.isSick()) {
                    animal.setSick(false);
                    zoo.updateSickAnimalCount(zoo.getNumSickAnimals() - 1);
                    zoo.updateHealthyAnimalCount(zoo.getNumHealthyAnimals() + 1);
                    System.out.println("Animal with ID " + animalID + " in Enclosure " + enclosureID + " has been treated and is now healthy.");
                } else {
                    System.out.println("Animal with ID " + animalID + " in Enclosure " + enclosureID + " is already healthy.");
                }

                // Display updated statistics after treatment
                viewZooStat();
                break;
            }
        }

        // If the animal is not found
        if (!animalFound) {
            System.out.println("Error: Animal with ID " + animalID + " not found in Enclosure " + enclosureID + ".");
        }
    }

    public static void viewZooStat() {
    }

    public static void viewAnimalHealth() {
        if (zoo == null) {
            System.out.println("Zoo not set for Veterinarian.");
            return;
        }
        System.out.println("\nNumber of Existing Animals: " + zoo.getNumAnimals());
        System.out.println("\nNumber of Sick and Healthy Animals:");
        int numSickAnimals = zoo.getNumSickAnimals();
        int numHealthyAnimals = zoo.getNumHealthyAnimals();
        System.out.println("Sick Animals: " + numSickAnimals);
        System.out.println("Healthy Animals: " + numHealthyAnimals);
    }

    //    public static void treatAnimal(int animalID) {
//        if (zoo == null) {
//            System.out.println("Zoo not set.");
//            return;
//        }
//
//        // Find the animal with the specified ID
//        Animal targetAnimal = null;
//        for (Animal animal : zoo.getAnimals()) {
//            if (animal.getAnimalID() == animalID) {
//                targetAnimal = animal;
//                break;
//            }
//        }
//
//        // If the animal is found, update its health status
//        if (targetAnimal != null) {
//            if (targetAnimal.isSick()) {
//                targetAnimal.setSick(false);
//                zoo.updateSickAnimalCount(zoo.getNumSickAnimals() - 1);
//                zoo.updateHealthyAnimalCount(zoo.getNumHealthyAnimals() + 1);
//                System.out.println("Animal with ID " + animalID + " has been treated and is now healthy.");
//            } else {
//                System.out.println("Animal with ID " + animalID + " is already healthy.");
//            }
//        } else {
//            System.out.println("Error: Animal with ID " + animalID + " not found in the zoo.");
//        }
//
//        // Display updated statistics after treatment
//        viewZooStat();
//    }
}

