import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Employee> employees;

    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

    // Thêm một nhân viên từ console
    public void createEmployeeFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter birth day (yyyy-MM-dd):");
        String birthDayStr = scanner.nextLine();
        Date birthDay = parseDate(birthDayStr);

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter employee type (Experience/Fresher/Intern):");
        String employeeType = scanner.nextLine();

        switch (employeeType.toLowerCase()) {
            case "experience":
                System.out.println("Enter years of experience:");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                System.out.println("Enter professional skill:");
                String proSkill = scanner.nextLine();
                employees.add(new ExperienceEmployee(fullName, birthDay, phone, email, expInYear, proSkill));
                break;
            case "fresher":
                System.out.println("Enter graduation date (yyyy-MM-dd):");
                String graduationDateStr = scanner.nextLine();
                Date graduationDate = parseDate(graduationDateStr);
                System.out.println("Enter graduation rank:");
                String graduationRank = scanner.nextLine();
                System.out.println("Enter education:");
                String education = scanner.nextLine();
                employees.add(new FresherEmployee(fullName, birthDay, phone, email, graduationDate, graduationRank, education));
                break;
            case "intern":
                System.out.println("Enter major:");
                String majors = scanner.nextLine();
                System.out.println("Enter semester:");
                int semester = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                System.out.println("Enter university name:");
                String universityName = scanner.nextLine();
                employees.add(new InternEmployee(fullName, birthDay, phone, email, majors, semester, universityName));
                break;
            default:
                System.out.println("Invalid employee type.");
        }
    }

    // Hiển thị tất cả các nhân viên
    public void displayAllEmployees() {
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println();
        }
    }

    public void updateEmployee(int ID, String fullName, Date birthDay, String phone, String email, String employeeType) {
        for (Employee employee : employees) {
            if (employee.getID() == ID) {
                employee.setFullName(fullName);
                employee.setBirthDay(birthDay);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setEmployeeType(employeeType);
                return;
            }
        }
        System.out.println("Employee with ID " + ID + " not found.");
    }

    public void deleteEmployee(int ID) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getID() == ID) {
                iterator.remove();
                System.out.println("Employee with ID " + ID + " has been deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + ID + " not found.");
    }

    public void saveToFileFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to save:");
        String fileName = scanner.nextLine();
        saveToFile(fileName);
    }

    public void loadFromFileFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to load:");
        String fileName = scanner.nextLine();
        loadFromFile(fileName);
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Data loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
