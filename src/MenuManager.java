import libs.AnimalHandler;
import libs.Manager;
import libs.Veterinarian;
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
                "2 - Employees",
                "3 - Exit\n"
        };
        scanner = new Scanner(System.in);

        while (option != 3) {
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
                        System.out.print("Thank you for visiting, see you again soon!\n");
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
        int choice = 1;
        String[] visitorOptions = {"\n1 - Check into the Zoo",
                "2 - Check out of the Zoo",
                "3 - Back \n"
        };

        while (choice != 3) {
            printMenu(visitorOptions);
            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > visitorOptions.length) {
                    System.out.println("\n Please enter an integer between 1 and " + visitorOptions.length);
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter Visitor's First Name: ");
                        String checkInFirstName = scanner.next();
                        System.out.print("Enter Visitor's Last Name: ");
                        String checkInLastName = scanner.next();
                        System.out.print("Enter Visitor's Age: ");
                        int checkInAge = scanner.nextInt();
                        // rest of the code...
                        break;
                    case 2:
                        System.out.print("Enter Visitor's First Name: ");
                        String checkOutFirstName = scanner.next();
                        System.out.print("Enter Visitor's Last Name: ");
                        String checkOutLastName = scanner.next();
                        break;
                    case 3:
                        System.out.print("\nReturning to the previous menu!\n");
                        break;
                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("\n Please enter a valid integer.");
                scanner.next();
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

            try {
                int choice = scanner.nextInt();

                if (choice < 1 || choice > employeeOptions.length) {
                    System.out.println("\n Please enter an integer between 1 and " + employeeOptions.length);
                    continue;
                }

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
                        break;

                    case 4:
                        System.out.print("\nReturning to previous menu!\n");
                        return;

                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\nPlease enter an integer between 1 and " + employeeOptions.length);
                scanner.next();
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
        String[] managerOptions = {"\n1 - Add an employee",
                "2 - Remove an employee",
                "3 - Display all employees",
                "4 - View Zoo statistics",
                "5 - Back\n"
        };

        while (true) {
            printMenu(managerOptions);

            try {
                int choice = scanner.nextInt();

                if (choice < 1 || choice > managerOptions.length) {
                    System.out.println("\n Please enter an integer between 1 and " + managerOptions.length);
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee's First Name: ");
                        String addFirstName = scanner.next();
                        System.out.print("Enter Employee's Last Name: ");
                        String addLastName = scanner.next();
                        System.out.print("Enter Employee's Role (No Spaces!): ");
                        String addRole = scanner.next();
                        System.out.print("Enter Employee's ID: ");
                        int addEmployeeId = scanner.nextInt();
                        System.out.print("Enter Employee's Phone: ");
                        String addPhone = scanner.next();

                        Manager.addEmployee(addFirstName, addLastName, addRole, addEmployeeId, addPhone);
                        break;
                    case 2:
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
                        System.out.print("\nReturning to the previous menu!\n");
                        return;
                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\n Please enter an integer between 1 and " + managerOptions.length);
                scanner.next();
            }
        }
    }


    private static void animalHandlerMenu() {
        String[] aHandlerOptions = {
                "\n1 - Add Animal",
                "2 - Remove Animal",
                "3 - Feed Animal",
                "4 - Feed Enclosure",
                "5 - Back\n"
        };

        while (true) {
            printMenu(aHandlerOptions);

            try {
                int choice = scanner.nextInt();

                if (choice < 1 || choice > aHandlerOptions.length) {
                    System.out.println("\n Please enter an integer between 1 and " + aHandlerOptions.length);
                    continue;
                }

                switch (choice) {
                    case 1:
                        AnimalFactory.createAnimal();
                        break;
                    case 2:
                        AnimalFactory.removeAnimal();
                        break;
                    case 3:
                        System.out.print("Enter Animal ID: ");
                        int animalID = scanner.nextInt();
                        System.out.print("Enter Enclosure ID: ");
                        int enclosureID = scanner.nextInt();
                        AnimalHandler.feedAnimal(animalID, enclosureID);
                        break;
                    case 4:
                        System.out.print("Enter Enclosure ID: ");
                        enclosureID = scanner.nextInt();
                        AnimalHandler.feedEnclosure(enclosureID);
                        break;
                    case 5:
                        System.out.print("\nReturning to the previous menu!\n");
                        return;
                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\n Please enter an integer between 1 and " + aHandlerOptions.length);
                scanner.next();
            }
        }
    }


    private static void vetMenu() {
        String[] vetOptions = {
                "\n1 - Treat Animal",
                "2 - View Animals Health",
                "3 - Back"
        };

        while (true) {
            printMenu(vetOptions);

            try {
                int choice = scanner.nextInt();

                if (choice < 1 || choice > vetOptions.length) {
                    System.out.println("\n Please enter an integer between 1 and " + vetOptions.length);
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter Animal ID: ");
                        int animalID = scanner.nextInt();
                        System.out.print("Enter Enclosure ID: ");
                        int enclosureID = scanner.nextInt();
                        Veterinarian.treatAnimal(animalID, enclosureID);
                        break;
                    case 2:
                        Veterinarian.viewAnimalHealth();
                        break;
                    case 3:
                        System.out.print("\nReturning to the previous menu!\n");
                        return;
                    default:
                        System.out.println("\nInvalid choice!\n");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("\n Please enter an integer between 1 and " + vetOptions.length);
                scanner.next();
            }
        }
    }

}


