import java.sql.*;
import java.util.Scanner;

// Program to insert multiple data rows into the table dynamically

public class jdbcdurga5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        Scanner sc = new Scanner(System.in);
        int affectedrows;
        String option;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();

            while(true){
                System.out.println("Enter employee name");
                String name = sc.next();
                System.out.println("Enter employee salary");
                int salary = sc.nextInt();
                System.out.println("Enter employee address");
                String address = sc.next();
                String sql = String.format("INSERT INTO employees(ename,esal,eaddr)VALUES" +
                        "('%s',%d,'%s')",name,salary,address);

                affectedrows = st.executeUpdate(sql);
                if(affectedrows>0)
                    System.out.println("Insertion successfull");
                else
                    System.out.println("Insertion failed");

                System.out.println("Do you want to insert more records? [Yes/No]");
                option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}




