import libs.AnimalHandler;
import libs.Manager;
import libs.Veterinarian;
import libs.Visitor;
import Zoo.Zoo;
import Zoo.AnimalFactory;
import java.util.Scanner;


public class MenuManager {
    private static Scanner scanner;
    private static Manager manager;


    public MenuManager() {
        this.scanner = new Scanner(System.in);
    }

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void Menu() {
        int option = 1;
        System.out.println("\n|---Zoo Menu---|\n");
        String[] options = {"1 - Visitors",
                "2 - Employees\n",
        };
        scanner = new Scanner(System.in);

        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        manageVisitor();
                        break;
                    case 2:
                        manageEmployee();
                        break;
                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\n Please enter an integer between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    private static void manageVisitor() {
        String[] visitorOptions = {"\n1 - Check into the Zoo",
                "2 - Check out of the Zoo",
                "3 - Back \n"
        };

        while (true) {
            printMenu(visitorOptions);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Visitor's First Name: ");
                    String checkInFirstName = scanner.next();
                    System.out.print("Enter Visitor's Last Name: ");
                    String checkInLastName = scanner.next();
                    System.out.print("Enter Visitor's Age: ");
                    int checkInAge = scanner.nextInt();
                    System.out.print("Enter Visitor's Phone: \n");
                    String checkInPhone = scanner.next();

                    Visitor.visitZoo(checkInFirstName, checkInLastName, checkInAge, checkInPhone);
                    break;
                case 2:
                    System.out.print("Enter Visitor's First Name: ");
                    String checkOutFirstName = scanner.next();
                    System.out.print("Enter Visitor's Last Name: \n");
                    String checkOutLastName = scanner.next();
                    Visitor.removeVisitorFromZoo(checkOutFirstName, checkOutLastName);
                    break;
                case 3:
                    break;
            }
        }
    }


    private static void manageEmployee() {
        String[] employeeOptions = {"\n1 - Manager",
                "2 - Animal Handler",
                "3 - Veterinarian",
                "4 - Back \n"
        };

        while (true) {
            printMenu(employeeOptions);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (manager == null) {
                        System.out.println("Manager instance doesn't exist. Creating a new Manager.\n");
                        createManager();
                    }
                    managerMenu();
                    break;

                case 2:
                    animalHandlerMenu();
                    break;

                case 3:
                    vetMenu();
                    return;

                default:
                    System.out.println("\nInvalid choice!\n");
                    break;
            }
        }
    }

    private static void createManager() {
        System.out.print("Enter Manager's First Name: ");
        String managerFirstName = scanner.next();
        System.out.print("Enter Manager's Last Name: ");
        String managerLastName = scanner.next();
        System.out.print("Enter Manager's Phone: \n");
        String managerPhone = scanner.next();

        // Create a new Manager instance
        manager = new Manager(managerFirstName, managerLastName, managerPhone, 1, "Manager");
        System.out.println("Manager instance created successfully.");

    }

    private static void managerMenu() {
        String[] managerOptions = {"\n1 - Add an employee",
                "2 - Remove an employee",
                "3 - Display all employees",
                "4 - View Zoo statistics\n"
        };

        while (true) {
            printMenu(managerOptions);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee's First Name: ");
                    String addFirstName = scanner.next();
                    System.out.print("Enter Employee's Last Name: ");
                    String addLastName = scanner.next();
                    System.out.print("Enter Employee's Role: ");
                    String addRole = scanner.next();
                    System.out.print("Enter Employee's ID: ");
                    int addEmployeeId = scanner.nextInt();
                    System.out.print("Enter Employee's Phone: \n");
                    String addPhone = scanner.next();

                    Manager.addEmployee(addFirstName, addLastName, addRole, addEmployeeId, addPhone);
                    break;
                case 2:
                    // Assuming you want to remove an employee by providing first and last names
                    System.out.print("Enter Employee's First Name: ");
                    String removeFirstName = scanner.next();
                    System.out.print("Enter Employee's Last Name: \n");
                    String removeLastName = scanner.next();
                    Manager.removeEmployee(removeFirstName, removeLastName);
                    break;
                case 3:
                    Manager.displayEmployeeList();
                    break;
                case 4:
                    Manager.viewZooStat();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nInvalid choice!\n");
                    break;
            }
        }
    }

    private static void animalHandlerMenu() {
        String[] aHandlerOptions = {
                "\n1 - Add Animal",
                "2 - Remove Animal",
                "3 - Feed Animal",
                "4 - Feed Enclosure"
        };

        while (true) {
            printMenu(aHandlerOptions);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    AnimalFactory.createAnimal();
                    break;
                case 2:
                    AnimalFactory.removeAnimal();
                    break;
                case 3:
                    System.out.print("Enter Animal ID: ");
                    int animalID = scanner.nextInt(); //TODO Check why animalID here do not connect with animalID in class
                    System.out.print("Enter Enclosure ID: ");
                    int enclosureID = scanner.nextInt();
                    AnimalHandler.feedAnimal(animalID, enclosureID);
                    break;
                case 4:
                    AnimalHandler.viewZooStat();
                    break;
            }

        }
    }

    private static void vetMenu() {
        String[] vetOptions = {
                "\n1 - Treat Animal"
        };

        while (true) {
            printMenu(vetOptions);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Animal ID: ");
                    int animalID = scanner.nextInt(); //TODO Check why animalID here do not connect with animalID in class
                    Veterinarian.treatAnimal(animalID);
                    break;
                case 2:
                    break;
            }
        }
    }
}


