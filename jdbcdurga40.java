import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;

// jdbc program to demonstrate connection pooling

class jdbcdurga40{
    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("/Users/virk/Desktop/firmly.txt");
        p.load(fis);

        String url = p.getProperty("Url");
        String username = p.getProperty("Username");
        String password = p.getProperty("Password");
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM employees";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int salary = rs.getInt(3);
                String address = rs.getString(4);
                System.out.println(id);
                System.out.println(name);
                System.out.println(salary);
                System.out.println(address);
                System.out.println();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
