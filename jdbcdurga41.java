import java.sql.*;
import java.util.*;
import java.io.*;

// jdbc program to demonstrate the properties files

public class jdbcdurga41 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("/Users/virk/Desktop/db.properties");
        p.load(fis);
        String username = p.getProperty("username");
        System.out.println(username);
        Connection con = DriverManager.getConnection(url,p);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");

        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
        }
        con.close();
    }
}
