import java.sql.*;
import java.util.Scanner;

// Program to select particular coloumns from the table

public class jdbcdurga15 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        String sql = "SELECT ename, eaddr FROM employees";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                flag = true;
                String empName = rs.getString(1);
                String empAddr = rs.getString(2);
                System.out.println("+-------------------------+");
                System.out.println("Name: "+empName);
                System.out.println("Address:"+empAddr);
                System.out.println();
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
