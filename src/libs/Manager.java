package libs;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import Zoo.*;



public class Manager extends Employee {
    static  Zoo zoo;
    static String filePath = "src/data/employees";


    public Manager(String firstName, String lastName, String phone, int employeeId, String role) {
        super(firstName, lastName, phone, employeeId, role);
    }

    public static void setZoo(Zoo zoo) {
        Manager.zoo = zoo;
    }

    public static void addEmployee(String firstName, String lastName, String role, int employeeId, String phone) {
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write("Employee Name: " + firstName + " " + lastName + "\n");
            writer.write("Role: " + role + "\n");
            writer.write("ID: " + employeeId + "\n");
            writer.write("Phone: " + phone + "\n");
            writer.write("------------------------\n");

            System.out.println("Employee added successfully to the system.\n");
        } catch (IOException e) {
            System.err.println("Error adding employee to the system:\n " + e.getMessage());
        }
    }

    public static void removeEmployee(String firstName, String lastName) {

        Path path = Paths.get(filePath);

        try {
            // Read all lines from the file
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the employee ID
                if (!line.contains("Employee Name: " + firstName + " " + lastName)) {
                    content.append(line).append("\n");
                } else {
                    // Skip the entire entry for the specified employee
                    skipEmployeeEntry(reader);
                }
            }

            // Close the reader
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
            writer.write(content.toString());
            writer.close();

            System.out.println("Employee has been successfully removed from the system.\n");
        } catch (IOException e) {
            System.err.println("Error removing employee from the system:\n " + e.getMessage());
        }
    }

    // Helper method to skip the entire entry for a visitor
    private static void skipEmployeeEntry(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.equals("------------------------")) {
        }
    }

    public static void displayEmployeeList() {
        Path path = Paths.get(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading employee list: " + e.getMessage());
        }
    }

    public static void viewZooStat() {
        if (zoo == null) {
            System.out.println("Zoo not set for the Manager.");
            return;
        }

        System.out.println("|--Zoo Overview--|");
        System.out.println("\nNumber of Existing Animals: " + zoo.getNumAnimals());
        System.out.println("Number of Enclosures: " + zoo.getNumEnclosures());
        System.out.println("Average Animal Age: " + zoo.getAverageAnimalAge());
        System.out.println("Average Animal Weight: " + zoo.getAverageAnimalWeight());

        // Display number of animals in each enclosure
        System.out.println("\nNumber of Animals in Each Enclosure:");
        for (int enclosureId = 0; enclosureId < zoo.getNumEnclosures(); enclosureId++) {
            int animalsInEnclosure = zoo.getAnimalsInEnclosure(enclosureId);
            System.out.println("Enclosure " + enclosureId + ": " + animalsInEnclosure + " animals");
        }

        // Display number of sick and healthy animals
        System.out.println("\nNumber of Sick and Healthy Animals:");
        int numSickAnimals = zoo.getNumSickAnimals();
        int numHealthyAnimals = zoo.getNumHealthyAnimals();
        System.out.println("Sick Animals: " + numSickAnimals);
        System.out.println("Healthy Animals: " + numHealthyAnimals);
    }


}