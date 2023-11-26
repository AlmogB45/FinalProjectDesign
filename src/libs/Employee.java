package libs;

public class Employee extends Person {
    private static int employeeId;
    private static String role;

    public Employee(String firstName, String lastName, String phone, int employeeId, String role) {
        super(firstName, lastName, phone);
        this.employeeId = employeeId;
        this.role = role;
    }

    public static int getEmployeeId() {
        return employeeId;
    }

    public static String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Employee{" +
                "employeeId=" + employeeId +
                ", role='" + role + '\'' +
                '}';
    }
}
