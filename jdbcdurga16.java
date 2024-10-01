import java.sql.*;
import java.util.Scanner;

// Program to display no of rows by aggregate function Count(*);

public class jdbcdurga16 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        String sql = "SELECT COUNT(*) FROM employees";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                flag = true;
                System.out.println("No of employees: " + rs.getInt(1));
            }

            if(flag == false)
                System.out.println("no records found");
            sc.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
