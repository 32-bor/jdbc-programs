import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Type;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

// jdbc program to insert date and time into the database

class jdbcdurga32 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "insert into users(name,dop) VALUES(?,?)";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement(sql);

            while (true){
                System.out.println("Enter  name");
                String name = sc.next();
                System.out.println("Enter  DOP (dd-mm-yyyy");
                String dop = sc.next();

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date udate = sdf.parse(dop);
                long l = udate.getTime();
                java.sql.Date sdate = new java.sql.Date(l);

                pst.setString(1,name);
                pst.setDate(2,sdate);
                int affectedRows = pst.executeUpdate();
                if(affectedRows>0)
                    System.out.println("Insertion successful");
                else
                    System.out.println("Insertion failed");
                System.out.println("Do you want to add more records? [yes/no]");
                String option = sc.next();
                if(option.equalsIgnoreCase("no"))
                    break;
            }
        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
