import java.sql.*;
import java.util.Scanner;

// Program to show SQL Injection attack using Statement Object

public class jdbcdurga24 {
    public static void main(String[] args)  {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String uname = sc.next();
        System.out.println("Enter password");
        String upwd = sc.next();
        String sql = "SELECT COUNT(*) FROM users WHERE uname = ? AND upwd = ?";
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,uname);
            pst.setString(2,upwd);
            ResultSet rs = pst.executeQuery();
            int c = 0;
            if(rs.next())
                c = rs.getInt(1);
            if(c ==0)
                System.out.println("Invalid credentials");
            else
                System.out.println("valid credentials");
            sc.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
