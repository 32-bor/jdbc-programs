import java.sql.*;
import java.util.Scanner;

// Program to demonstrate prepared statement

public class jdbcdurga21 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        String sql = "insert into employees(ename,esal, eaddr) VALUES(?,?,?)";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);

            while(true){
                System.out.println("Enter employee name: ");
                String empName = sc.next();
                System.out.println("Enter employee salary: ");
                int empSalary = sc.nextInt();
                System.out.println("Enter employee address:");
                String empAddress = sc.next();
                pst.setString(1,empName);
                pst.setInt(2,empSalary);
                pst.setString(3,empAddress);
                int affectedRows = pst.executeUpdate();
                if(affectedRows>0)
                    System.out.println("Insertion successfull");
                else
                    System.out.println("Insertion failed");
                System.out.println("Do you want to insert more records ? [Yes/No]");
                String option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
                else
                    continue;
            }
            sc.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
