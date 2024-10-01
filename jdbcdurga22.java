import java.sql.*;
import java.util.Scanner;

// Program to Delete records by using prepared statement

public class jdbcdurga22 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        String sql = "DELETE FROM employees WHERE ename = ?";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);

            while(true){
                System.out.println("Enter employee name to delete: ");
                String empName = sc.next();
                pst.setString(1,empName);
                int affectedRows = pst.executeUpdate();
                if(affectedRows>0)
                    System.out.println("Deletion successfull");
                else
                    System.out.println("Deletion failed");
                System.out.println("Do you want to delete more records ? [Yes/No]");
                String option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
            }
            sc.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
