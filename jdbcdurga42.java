import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class jdbcdurga42 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        String sql1 = "UPDATE accounts SET balance = balance - 10000 WHERE name = 'durga'";
        String sql2 = "UPDATE accounts SET balance = balance + 10000 WHERE name = 'sunny'";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM accounts");
        System.out.println("Data before transaction");
        System.out.println("=========================");
        while(rs.next()){
            String name = rs.getString(1);
            int balance = rs.getInt(2);
            System.out.println(name);
            System.out.println(balance);
        }
        System.out.println("Transaction begins");
        con.setAutoCommit(false);
        st.executeUpdate(sql1);
        st.executeUpdate(sql2);
        System.out.println("Can you please confirm this transaction? [yes/no]");
        String option = sc.next();
        if(option.equalsIgnoreCase("yes"))
            con.commit();
        else
            con.rollback();
        System.out.println("Data after transaction");
        System.out.println("=========================");
        ResultSet rs2 = st.executeQuery("select * from accounts");
        while(rs2.next()){
            String name = rs2.getString(1);
            int balance = rs2.getInt(2);
            System.out.println(name);
            System.out.println(balance);
        }
    }
}
