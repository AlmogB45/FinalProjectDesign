package libs;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class Visitor extends Person {
    private static int age;
    static String filePath = "src/data/visits";

    public Visitor(String firstName, String lastName, String phone, int age) {
        super(firstName, lastName, phone);

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void visitZoo(String firstName, String lastName, int age, String phone) {
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write("Visitor Name: " + firstName + " " + lastName + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Phone: " + phone + "\n");
            writer.write("------------------------\n");

            System.out.println("Visitor details written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }


    public static void removeVisitorFromZoo(String firstName, String lastName) {

        Path path = Paths.get(filePath);

        try {
            // Read all lines from the file
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the visitor's first and last names
                if (!line.contains("Visitor Name: " + firstName + " " + lastName)) {
                    content.append(line).append("\n");
                } else {
                    skipVisitorEntry(reader);
                }
            }

            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()));
            writer.write(content.toString());
            writer.close();

            System.out.println("Visitor removed from the file successfully.");
        } catch (IOException e) {
            System.err.println("Error removing visitor from the file: " + e.getMessage());
        }
    }

    // Helper method to skip the entire entry for a visitor
    private static void skipVisitorEntry(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null && !line.equals("------------------------")) {
            // Skip lines until reaching the end of the visitor entry
        }
    }
}



