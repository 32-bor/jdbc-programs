import java.sql.*;
import java.util.Scanner;

public class jdbcdurga43 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Scanner sc = new Scanner(System.in);
        String sql1 = "INSERT INTO politicians(name,party) VALUES('kcr','trs')";
        String sql2 = "INSERT INTO politicians(name,party) VALUES('babu','tdp')";
        String sql3 = "INSERT INTO politicians(name,party) VALUES('sidhu','congress')";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        con.setAutoCommit(false);
        st.executeUpdate(sql1);
        st.executeUpdate(sql2);
        Savepoint sp = con.setSavepoint();
        st.executeUpdate(sql3);
        System.out.println("wrong entry , rollback....");
        con.rollback(sp);
        System.out.println("operations rolled back from savepoint");
        con.commit();
        System.out.println(con.getTransactionIsolation());
    }
}
