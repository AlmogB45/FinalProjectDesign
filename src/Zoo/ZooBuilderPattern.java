package Zoo;

import libs.Manager;

import java.util.Scanner;

public class ZooBuilderPattern { //TODO Check validity of this class to avoid duplications!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting input for Manager properties
        System.out.print("Enter Manager's First Name: ");
        String managerFirstName = scanner.next();
        System.out.print("Enter Manager's Last Name: ");
        String managerLastName = scanner.next();
        System.out.print("Enter Manager's Phone: ");
        String managerPhone = scanner.next();

        // Creating a Manager instance with user input
        Manager manager = new Manager(managerFirstName, managerLastName, managerPhone, 1, "Manager");

        // Getting input for Zoo properties
        System.out.print("Enter the number of animals: ");
        int animalCount = scanner.nextInt();
        System.out.print("Enter the number of enclosures: ");
        int enclosureCount = scanner.nextInt();

        // Creating a ZooBuild object using the user input
        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
                .setAnimalCount(animalCount)
                .setEnclosureCount(enclosureCount)
                .build();

        // Creating a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooBuild);

        // Passing the Zoo instance to the Manager
        manager.setZoo(zoo);
        ;
        // Creating an AnimalFactory object and passing the Zoo object
        AnimalFactory animalFactory = new AnimalFactory(zoo);

        // Creating animals using the AnimalFactory
        animalFactory.createAnimal();
        animalFactory.createAnimal();

        // View the updated zoo statistics
    }
}


