package Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int animalCount;
    private int enclosureCount;
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

        while (animalsInEnclosures.size() <= enclosureId) {
            animalsInEnclosures.add(0);
        }

        animalsInEnclosures.set(enclosureId, animalsInEnclosures.get(enclosureId) + 1);
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

    public int getAnimalsInEnclosure(int enclosureId) {
        if (enclosureId < animalsInEnclosures.size()) {
            return animalsInEnclosures.get(enclosureId);
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
        int count = 0;
        for (Animal animal : animals) {
            if (animal.isSick()) {
                count++;
            }
        }
        return count;
    }
}

class Animal {
    private String name;
    private int age;
    private double weight;
    private boolean isSick;
    private String color;
    private int animalID;
    private int enclosureID;

    public Animal(String name, int age, double weight, boolean isSick, String color, int animalID, int enclosureID) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.isSick = isSick;
        this.color = color;
        this.animalID = animalID;
        this.enclosureID = enclosureID;
    }

    // Getter methods for the new attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isSick() {
        return isSick;
    }

    public String getColor() {
        return color;
    }

    public int getAnimalID() {
        return animalID;
    }

    public int getEnclosureID() {
        return enclosureID;
    }
}

