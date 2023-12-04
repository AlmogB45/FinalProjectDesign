package Zoo;

public class Animal {
    private String name;
    private int age;
    private double weight;
    private boolean isSick;
    private String color;
    private int animalID;
    private int enclosureID; //TODO Check relevance to AnimalHandler enclosureID

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
