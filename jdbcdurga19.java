import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

// Display the retrieved data from database through HTML

public class jdbcdurga19 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String data = "";
        String sql = "SELECT * FROM employees";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            data = data + "<html><body bgcolor='green' text='white'><center><table border='2'>";
            data = data + "<tr><td>id</td><td>ename</td><td>esal</td><td>eddr</td></tr>";

            while(rs.next()){
                data = data + "<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" +
                       rs.getDouble(3) + "<td></td>" + rs.getString(4) + "<td></td>";
            }
            data = data + "</table></center></body></html>";

            FileOutputStream fos = new FileOutputStream("emp.html");
            byte[] b = data.getBytes();
            fos.write(b);
            fos.flush();
            System.out.println("Open emp.html to get employees data");
            fos.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
