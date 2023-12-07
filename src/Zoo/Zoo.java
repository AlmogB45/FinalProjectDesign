package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int animalCount;
    private int enclosureCount;
    private int healthyAnimalCount;
    private int sickAnimalCount;
    private List<Animal> animals;
    private List<Integer> animalsInEnclosures;  // List to store the number of animals in each enclosure

    public Zoo(ZooBuild zooBuild) {
        this.animalCount = zooBuild.getAnimalCount();
        this.enclosureCount = zooBuild.getEnclosureCount();
        this.animals = new ArrayList<>();
        this.animalsInEnclosures = new ArrayList<>();
    }

    public Zoo() {
        animals = new ArrayList<>();
        animalsInEnclosures = new ArrayList<>();
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getEnclosureCount() {
        return enclosureCount;
    }

    public void updateAnimalCount(int newCount) {
        animalCount = newCount;
    }

    public void updateEnclosureCount(int newCount) {
        enclosureCount = newCount;
    }

    public void addAnimal(Animal animal, int enclosureId) {
        animals.add(animal);

        // Ensure that the animalsInEnclosures list has enough elements
        while (animalsInEnclosures.size() <= enclosureId) {
            animalsInEnclosures.add(0);
        }

        // Update the count of animals in the enclosure
        animalsInEnclosures.set(enclosureId, animalsInEnclosures.get(enclosureId) + 1);
    }

    public boolean removeAnimal(int animalID) {
        // Find the index of the animal with the specified ID
        int indexToRemove = -1;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalID() == animalID) {
                indexToRemove = i;
                break;
            }
        }

        // If the animal is found, remove it
        if (indexToRemove != -1) {
            Animal removedAnimal = animals.remove(indexToRemove);

            // Update the count of animals in the enclosure
            int enclosureID = removedAnimal.getEnclosureID();
            animalsInEnclosures.set(enclosureID, animalsInEnclosures.get(enclosureID) - 1);

            return true;
        } else {
            return false; // Animal not found
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getNumAnimals() {
        return animals.size();
    }

    public int getNumEnclosures() {
        int count = 0;
        for (Integer numAnimals : animalsInEnclosures) {
            if (numAnimals > 0) {
                count++;
            }
        }
        return count;
    }

    public int getAnimalsInEnclosure(int enclosureID) {
        if (enclosureID < animalsInEnclosures.size()) {
            return animalsInEnclosures.get(enclosureID);
        } else {
            return 0;
        }
    }

    public double getAverageAnimalAge() {
        if (animals.isEmpty()) {
            return 0.0;
        }

        double totalAge = 0;
        for (Animal animal : animals) {
            totalAge += animal.getAge();
        }
        return totalAge / animals.size();
    }

    public double getAverageAnimalWeight() {
        if (animals.isEmpty()) {
            return 0.0;
        }

        double totalWeight = 0;
        for (Animal animal : animals) {
            totalWeight += animal.getWeight();
        }
        return totalWeight / animals.size();
    }

    public int getNumSickAnimals() {
        int sickCount = 0; // Initialize a local variable to store the count

        for (Animal animal : animals) {
            if (animal.isSick()) {
                sickCount++;
            }
        }
        return sickCount;
    }

    public int getNumHealthyAnimals() {
        for (Animal animal : animals) {
            if (animal.isHealthy()) {
                healthyAnimalCount++;
            }
        }
        return healthyAnimalCount;
    }

    public void updateSickAnimalCount(int newCount) {
        sickAnimalCount = newCount;
    }

    public void updateHealthyAnimalCount(int newCount) {
        healthyAnimalCount = newCount;
    }
}