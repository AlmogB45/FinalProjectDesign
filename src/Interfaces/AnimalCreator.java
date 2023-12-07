package Interfaces;

import Zoo.Animal;

public interface AnimalCreator {
    Animal createAnimal(String type, String name, int age, double weight, boolean isSick, String color, int animalID, int enclosureID);
}
