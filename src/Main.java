import Zoo.*;
import libs.Manager;

public class Main {
    public static void main(String[] args) {

        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
                .build();

        // Creating a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooBuild);

        // Setting the correct Zoo object for the manager
        Manager.setZoo(zoo);

        // Setting the AnimalFactory into the correct Zoo object
        AnimalFactory animalFactory = new AnimalFactory(zoo);

        // Calling the menuManager.
        MenuManager menuManager = new MenuManager();
        menuManager.Menu();
    }
}
