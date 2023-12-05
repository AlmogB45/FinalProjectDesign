package libs;

import Zoo.Zoo;
import Zoo.Animal;

public class Veterinarian extends Employee {
    private static final Zoo zoo = Manager.zoo;

    public Veterinarian(String firstName, String lastName, String phone, int employeeId, String role) {
        super(firstName, lastName, phone, employeeId, role);
    }

    public static void treatAnimal(int animalID) {
        if (zoo == null) {
            System.out.println("Zoo not set.");
            return;
        }

        // Find the animal with the specified ID
        Animal targetAnimal = null;
        for (Animal animal : zoo.getAnimals()) {
            if (animal.getAnimalID() == animalID) {
                targetAnimal = animal;
                break;
            }
        }

        // If the animal is found, update its health status
        if (targetAnimal != null) { //TODO check why method do not recognize sick animals when they ARE sick!
            if (targetAnimal.isSick()) {
                targetAnimal.setSick(false);
                zoo.updateSickAnimalCount(zoo.getNumSickAnimals() - 1);
                zoo.updateHealthyAnimalCount(zoo.getNumHealthyAnimals() + 1);
                System.out.println("Animal with ID " + animalID + " has been treated and is now healthy.");
            } else {
                System.out.println("Animal with ID " + animalID + " is already healthy.");
            }
        } else {
            System.out.println("Error: Animal with ID " + animalID + " not found in the zoo.");
        }

        // Display updated statistics after treatment
        viewZooStat();
    }

    public static void viewZooStat() {
        // This method should display the updated zoo statistics
        // It is assumed that the viewZooStat method exists in the Employee or Manager class
    }
}

