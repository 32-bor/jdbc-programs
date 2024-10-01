import java.sql.*;

// program to demonstrate JDBC DATABASE metadata methods

public class jdbcdurga45 {
    public static void main(String[] args) throws SQLException {

        int count = 0;
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection con = DriverManager.getConnection(url,username,password);
        DatabaseMetaData dbmd = con.getMetaData();

        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String[] types = null;

        ResultSet rs = dbmd.getTables(catalog,schemaPattern,tableNamePattern,types);
        while(rs.next()){
            count++;
            System.out.println(rs.getString(4));
        }
        System.out.println("The no of tables are : " + count);
        con.close();
    }
}
