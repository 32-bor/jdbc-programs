import java.sql.*;
import java.util.Scanner;

// Program to delete multiple rows

public class jdbcdurga9 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter salary cutoff for the employees to be deleted");
        String salaryCutoff = sc.nextLine();
        String sql = String.format("DELETE FROM employees WHERE esal > '%s'",salaryCutoff);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int rowsAffected = st.executeUpdate(sql);
            if(rowsAffected >0)
                System.out.println("deletion successful");
            else
                System.out.println("deletion failed");
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
