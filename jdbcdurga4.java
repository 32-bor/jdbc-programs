import java.sql.*;
import java.util.Scanner;

// Program to insert data into the table dynamically

public class jdbcdurga4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name");
        String name = sc.next();
        System.out.println("Enter employee salary");
        int salary = sc.nextInt();
        System.out.println("Enter employee address");
        String address = sc.next();
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";

        // String sql = "INSERT INTO employees(ename,esal,eaddr)VALUES(" + "'" +
        // name +"'," + salary + ",'" + address +"')";
        // This is a complicated way to use sql query when we are using dynamic input

        String sql = String.format("INSERT INTO employees(ename,esal,eaddr)VALUES('%s',%d,'%s')",name,salary,address);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int affectedRows = st.executeUpdate(sql);

            if(affectedRows>0){
                System.out.println("Insertion completed successfully");
            }else{
                System.out.println("Insertion failed");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
