import java.sql.*;
import java.util.Scanner;

// Program to update multiple rows

public class jdbcdurga7 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary cutoff for the update");
        int salaryCutoff = sc.nextInt();
        System.out.println("Enter the increment to be provided");
        int increment = sc.nextInt();
        String sql = String.format("UPDATE employees set esal = esal + %d WHERE  esal < %d",increment,salaryCutoff);

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
                System.out.println("udation successful");
            else
                System.out.println("updation failed");
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
