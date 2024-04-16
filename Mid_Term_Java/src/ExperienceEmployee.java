import java.io.Serializable;
import java.util.Date;

public class ExperienceEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int expInYear;
    private String proSkill;

    public ExperienceEmployee(String fullName, Date birthDay, String phone, String email, int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, "Experience");
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Experience in Years: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }
}
