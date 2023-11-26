package Zoo;

import libs.Manager;

public class ZooApplication {
    public void run() {
        // Create a ZooBuild object using the builder
        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
                .setAnimalCount(0)
                .setEnclosureCount(0)
                .build();

        // Create a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooBuild);

        // Create a Manager object
        Manager manager = new Manager("John", "Doe", "123-456-7890", 1, "Manager");

        // View the zoo statistics
        manager.viewZooStat(zoo);

        // Additional Manager functions...
    }
}

