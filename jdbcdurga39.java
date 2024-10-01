import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to demonstrate connection pooling

class jdbcdurga39{
    public static void main(String[] args) throws FileNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM employees";
        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = ds.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            FileWriter fw = new FileWriter("/Users/virk/Desktop/firmly.txt");

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
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
