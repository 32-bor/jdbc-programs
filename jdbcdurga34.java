import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to read date values from the database

class jdbcdurga34{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM users";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            while (rs.next()){
                String name = rs.getString(1);
                java.sql.Date sdate = rs.getDate(2);
                String s = sdf.format(sdate);
                System.out.println(name);
                System.out.println(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
