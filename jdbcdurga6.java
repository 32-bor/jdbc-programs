import java.sql.*;
import java.util.Scanner;

// Program to update single row

public class jdbcdurga6 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the updated salary");
        int salary = sc.nextInt();
        String sql = String.format("UPDATE employees SET esal = '%s' WHERE ename = 'sukhdeep'",salary);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int rowsaffected = st.executeUpdate(sql);
            if(rowsaffected>0)
                System.out.println("updated successfully");
            else
                System.out.println("updation failed");
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
