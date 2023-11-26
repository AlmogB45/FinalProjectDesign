package Zoo;
import libs.Manager;

public class ZooBuilderPattern {
    public static void main(String[] args) {
        // Creating a ZooBuild object using the builder
        ZooBuild zooBuild = new ZooBuild.ZooBuilder()
                .setAnimalCount(0)
                .setEnclosureCount(0)
                .build();

        // Creating a Zoo object using the ZooBuild object
        Zoo zoo = new Zoo(zooBuild);

        // Creating a Manager instance and passing the Zoo instance
        Manager manager = new Manager("John", "Doe", "123-456-7890", 1, "Manager");
        manager.viewZooStat(zoo);

        // Creating an AnimalFactory object and passing the Zoo object
        AnimalFactory animalFactory = new AnimalFactory(zoo);

        // Creating animals using the AnimalFactory
        animalFactory.createAnimal();
        animalFactory.createAnimal();
    }
}

