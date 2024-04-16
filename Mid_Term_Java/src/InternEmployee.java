import java.io.Serializable;
import java.util.Date;

public class InternEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String majors;
    private int semester;
    private String universityName;

    public InternEmployee(String fullName, Date birthDay, String phone, String email, String majors, int semester, String universityName) {
        super(fullName, birthDay, phone, email, "Intern");
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
