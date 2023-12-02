package Zoo;

import java.util.Scanner;

public class AnimalFactory {
    private Zoo zoo;

    public AnimalFactory(Zoo zoo) {
        this.zoo = zoo;
    }

    public void createAnimal() {
        Scanner scanner = new Scanner(System.in);

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

        Animal newAnimal = new Animal(name, age, weight, false, color, animalID, enclosureID);


        // Add the new animal to the zoo
        zoo.addAnimal(newAnimal, enclosureID);

        // Update counts and averages in the zoo
        zoo.updateAnimalCount(zoo.getNumAnimals() + 1); //TODO במקרה של ספירת חיות לא תקינה, לבדוק את ה-1+
        zoo.updateEnclosureCount(zoo.getNumEnclosures());

        // Display updated statistics
        System.out.println("Animal added successfully!");
        System.out.println("Updated Animal Count: " + zoo.getAnimalCount());
        System.out.println("Updated Enclosure Count: " + zoo.getEnclosureCount());
        System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
        System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());
    }
}
