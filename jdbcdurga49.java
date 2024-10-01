import java.sql.*;

// program to check if the database supports required resultset type

public class jdbcdurga49 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection con = DriverManager.getConnection(url,username,password);
        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println(dbmd.supportsResultSetType(1004));
        System.out.println(dbmd.supportsResultSetType(1005));
        System.out.println(dbmd.supportsResultSetType(1003));
        System.out.println(dbmd.supportsResultSetConcurrency(1003,1007));
        System.out.println(dbmd.supportsResultSetConcurrency(1003,1008));
    }
}
