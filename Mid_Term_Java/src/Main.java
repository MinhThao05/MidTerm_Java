import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Database database = new Database();
        EmployeeManagement management = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Save Employees to File");
            System.out.println("6. Load Employees from File");
            System.out.println("7. Exit");
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    management.createEmployeeFromConsole();
                    break;
                
                case 2:
                    management.displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Enter employee ID to update:");
                    int updateID = scanner.nextInt();
                    scanner.nextLine(); 
                    break;
                case 4:
                    System.out.println("Enter employee ID to delete:");
                    int deleteID = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    break;
                case 5:
                    management.saveToFileFromConsole();
                    break;
                case 6:
                    management.loadFromFileFromConsole();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

}
