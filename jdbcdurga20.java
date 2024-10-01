import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

// Program to execute SELECT and NON-SELECT queries using execute method;

public class jdbcdurga20 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter query: ");
        String sql = sc.nextLine();

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            boolean b = st.execute(sql);

            if(b==true) // Select query
            {
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    // the result set processing code
                    System.out.println(rs.getInt(1)+"--"+rs.getString(2)+"--"+rs.getInt(3)+"--"+rs.getString(4));
                }
            }
            else // non select query
            {
                int updateCount = st.getUpdateCount();
                System.out.println("The no of rows affected: " + updateCount);
            }

            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
