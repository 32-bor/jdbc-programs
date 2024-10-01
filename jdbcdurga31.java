import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

// jdbc program to implement batch updates with prepared statement object

class jdbcdurga31 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "insert into employees(ename,esal, eaddr) VALUES(?,?,?)";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);

            while (true){
                System.out.println("Enter employee name");
                String name = sc.next();
                System.out.println("Enter employee salary");
                int salary = sc.nextInt();
                System.out.println("Enter employee address");
                String address = sc.next();
                pst.setString(1,name);
                pst.setInt(2,salary);
                pst.setString(3,address);
                pst.addBatch();
                System.out.println("Do you want to add more records? [yes/no]");
                String option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
            }
            int[] x = pst.executeBatch();
            int updateCount = 0;

            for(int x1 : x){
                updateCount += x1;
            }
            System.out.println("The no of rows updated: " + updateCount);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
