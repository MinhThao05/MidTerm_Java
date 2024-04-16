import java.io.Serializable;
import java.util.Date;

public class FresherEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public FresherEmployee(String fullName, Date birthDay, String phone, String email, Date graduationDate, String graduationRank, String education) {
        super(fullName, birthDay, phone, email, "Fresher");
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Graduation Date: " + graduationDate);
        System.out.println("Graduation Rank: " + graduationRank);
        System.out.println("Education: " + education);
    }
}
