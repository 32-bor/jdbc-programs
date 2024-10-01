import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to write CLOB date into the database

class jdbcdurga37{
    public static void main(String[] args) throws FileNotFoundException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "INSERT INTO cities(name,history) VALUES(?,?)";
        Scanner sc = new Scanner(System.in);
        File f = new File("/Users/virk/Documents/12_Dec.txt");
        FileReader fr = new FileReader(f);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);
            while (true){
                System.out.println("Enter name");
                String name = sc.next();
                pst.setString(1,name);
                pst.setCharacterStream(2,fr);
                System.out.println("inserting text.." + f.getAbsolutePath());
                int affectedRows = pst.executeUpdate();
                if(affectedRows > 0)
                    System.out.println("Insertion successfull");
                else
                    System.out.println("Insertion failed");
                System.out.println("Do you want to add more records ? [yes/no]");
                String option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
