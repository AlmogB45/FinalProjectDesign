import Zoo.*;
import java.util.Scanner;
import libs.Manager;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting input for Zoo properties
//        System.out.print("Enter the initial number of enclosures: ");
//        int enclosureCount = scanner.nextInt();

        // Creating a ZooBuild object using the user input
        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
//                .setEnclosureCount(enclosureCount)
                .build();

        // Creating a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooBuild);

        Manager.setZoo(zoo);

        // Creating an AnimalFactory object and passing the Zoo object
        AnimalFactory animalFactory = new AnimalFactory(zoo);
//
//        // Creating animals using the AnimalFactory
//        animalFactory.createAnimal();
//        animalFactory.createAnimal();



        // Now you can proceed to the MenuManager
        MenuManager menuManager = new MenuManager();
        menuManager.Menu();
    }
}
