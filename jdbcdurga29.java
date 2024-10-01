import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

// jdbc program to call stored procedure to return all employee's info

class jdbcdurga29 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            CallableStatement cst = con.prepareCall("{call getEmpInfo(?,?,?)}");
            cst.setInt(1,7);
            cst.registerOutParameter(2, Types.INTEGER);
            cst.registerOutParameter(3,Types.VARCHAR);
            cst.execute();
            int empSalary = cst.getInt(2);
            String empName = cst.getString(3);
            System.out.println(empSalary);
            System.out.println(empName);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
