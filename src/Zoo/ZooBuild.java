package Zoo;

public class ZooBuild {
    private int animalCount;
    private int enclosureCount;

    private ZooBuild() {
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getEnclosureCount() {
        return enclosureCount;
    }

    public static class ZooBuilder {
        private ZooBuild zooBuild = new ZooBuild();

        public ZooBuilder setAnimalCount(int aCount) {
            zooBuild.animalCount = aCount;
            return this;
        }

        public ZooBuilder setEnclosureCount(int eCount) {
            zooBuild.enclosureCount = eCount;
            return this;
        }

        public ZooBuild build() {
            return zooBuild;
        }
    }
}