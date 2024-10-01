import java.sql.*;
import java.util.Scanner;

// Program to delete single row

public class jdbcdurga8 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name to be deleted");
        String nameOfEmployee = sc.nextLine();
        String sql = String.format("DELETE FROM employees WHERE ename = '%s'",nameOfEmployee);

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
