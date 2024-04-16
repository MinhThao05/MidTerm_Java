import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Statement sttm;
	Connection con;
	private Statement stmt;
	public Database() {
		  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      try {
		           this.con = DriverManager.getConnection("jdbc"
		                        + ":mysql://localhost:3306/employeemanager?useUnicode=yes&characterEncoding=UTF-8","root","");
		           this.stmt = con.createStatement();
		           System.out.println("ok");
		                
		        } catch (SQLException e) {
		                // TODO Auto-generated catch block
		             e.printStackTrace();
		        }
	}
	 public void insertEmployee(String fullName, String birthDay, String phone, String email) {
	        String sql = "INSERT INTO employees (fullName, birthDay, phone, email) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, fullName);
	            pstmt.setString(2, birthDay);
	            pstmt.setString(3, phone);
	            pstmt.setString(4, email);
	            int rowsAffected = pstmt.executeUpdate();
	            System.out.println(rowsAffected + " row(s) inserted.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public void updateEmployee(int id, String fullName, String birthDay, String phone, String email) {
	        String sql = "UPDATE employees SET fullName = ?, birthDay = ?, phone = ?, email = ? WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, fullName);
	            pstmt.setString(2, birthDay);
	            pstmt.setString(3, phone);
	            pstmt.setString(4, email);
	            pstmt.setInt(5, id);
	            int rowsAffected = pstmt.executeUpdate();
	            System.out.println(rowsAffected + " row(s) updated.");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }

}


