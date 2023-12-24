import Zoo.*;
import libs.Manager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Zoo Name: ");
        String zooName = scanner.nextLine();

        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
                .build();

        // Creating a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooName, zooBuild);

        // Setting the correct Zoo object for the manager
        Manager.setZoo(zoo);

        // Setting the AnimalFactory into the correct Zoo object
        AnimalFactory animalFactory = new AnimalFactory(zoo);

        // Calling the menuManager.
        MenuManager menuManager = new MenuManager(zoo);
        menuManager.Menu();
    }
}
