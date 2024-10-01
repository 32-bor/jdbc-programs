import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to read BLOB date form the database

class jdbcdurga36{
    public static void main(String[] args) throws FileNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM persons";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            FileOutputStream fos = new FileOutputStream("/Users/virk/Desktop/newly_minted_image_from_DB.png");

            if(rs.next()){
                String name = rs.getString(1);
                InputStream is = rs.getBinaryStream(2);
                byte[] buffer = new byte[2048];
                while(is.read(buffer)>0){
                    fos.write(buffer);
                }
                fos.flush();
                System.out.println("open image");
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
