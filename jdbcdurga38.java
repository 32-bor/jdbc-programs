import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to read BLOB date form the database

class jdbcdurga38{
    public static void main(String[] args) throws FileNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM cities";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            FileWriter fw = new FileWriter("/Users/virk/Desktop/newly.txt");

            if(rs.next()){
                String name = rs.getString(1);
                Reader r = rs.getCharacterStream(2);
                char[] buffer = new char[2048];
                while(r.read(buffer)>0){
                    fw.write(buffer);
                }
                fw.flush();
                System.out.println("Open file");
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
