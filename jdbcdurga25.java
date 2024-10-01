import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;
// jdbc program to call stored procedure which can take 2 input numbers and produces the result

public class jdbcdurga25 {
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
            CallableStatement cst = con.prepareCall("{call addProc(?,?,?)}");
            cst.setInt(1,100);
            cst.setInt(2,2000);
            cst.registerOutParameter(3, Types.INTEGER);
            cst.execute();
            int result = cst.getInt(3);
            System.out.println("Result.."+result);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
