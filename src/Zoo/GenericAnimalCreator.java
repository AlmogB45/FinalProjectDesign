package Zoo;

import Interfaces.AnimalCreator;

public class GenericAnimalCreator implements AnimalCreator {
    @Override
    public Animal createAnimal(String type, String name, int age, double weight, boolean isSick, String color, int animalID, int enclosureID) {
        return new Animal(type, name, age, weight, isSick, color, animalID, enclosureID);
    }
}
