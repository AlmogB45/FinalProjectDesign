import libs.Manager;
import libs.Visitor;
import Zoo.Zoo;
import java.util.Scanner;


public class MenuManager {
    private static Scanner scanner;
    private Zoo zoo;
    private static Manager manager;



    public MenuManager() {
        this.zoo = zoo;
        this.manager = manager;
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
                "2 - Employees",
                "3 - ",
                "4 - Back"
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
                    case 3:

                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception ex) {
                System.out.println(" Please enter an integer between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    private static void manageVisitor() {
        String[] visitorOptions = {"1 - Check into the Zoo",
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
        String[] employeeOptions = {"1 - Manager",
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
                        System.out.println("Manager instance doesn't exist. Creating a new Manager.");
                        createManager();
                    }
                    managerMenu();
                    break;

                case 2:
                    break;

                case 3:
                    // Go back to the main menu
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void createManager() {
        System.out.print("Enter Manager's First Name: ");
        String managerFirstName = scanner.next();
        System.out.print("Enter Manager's Last Name: ");
        String managerLastName = scanner.next();
        System.out.print("Enter Manager's Phone: ");
        String managerPhone = scanner.next();

        // Create a new Manager instance
        manager = new Manager(managerFirstName, managerLastName, managerPhone, 1, "Manager");
        System.out.println("Manager instance created successfully.");

    }

    private static void managerMenu() {
        String[] managerOptions = {"1 - Add an employee",
                "2 - Remove an employee",
                "3 - Display all employees",
                "4 - View Zoo statistics"
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
                    System.out.print("Enter Employee's Phone: ");
                    String addPhone = scanner.next();

                    Manager.addEmployee(addFirstName, addLastName, addRole, addEmployeeId, addPhone);
                    break;
                case 2:
                    // Assuming you want to remove an employee by providing first and last names
                    System.out.print("Enter Employee's First Name: ");
                    String removeFirstName = scanner.next();
                    System.out.print("Enter Employee's Last Name: ");
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
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

}


