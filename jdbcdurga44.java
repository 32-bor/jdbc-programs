import java.sql.*;

// program to demonstrate jdbc metadata methods

public class jdbcdurga44 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection con = DriverManager.getConnection(url,username,password);
        DatabaseMetaData dbmd = con.getMetaData();

        System.out.println("Database product name: " + dbmd.getDatabaseProductName());
        System.out.println("Database product version: " + dbmd.getDatabaseProductVersion());
        System.out.println("Database major version: " + dbmd.getDatabaseMajorVersion());
        System.out.println("Database minor version: " + dbmd.getDatabaseMinorVersion());
        System.out.println("JDBC major version: " + dbmd.getJDBCMajorVersion());
        System.out.println("JDBC minor version: " + dbmd.getJDBCMinorVersion());
        System.out.println("Driver name: " + dbmd.getDriverName());
        System.out.println("Driver version: " + dbmd.getDriverVersion());
        System.out.println("Username: " + dbmd.getUserName());
        System.out.println("Max columns in Table: " + dbmd.getMaxColumnsInTable());
        System.out.println("Max row size: " + dbmd.getMaxRowSize());
        System.out.println("Max statement length: " + dbmd.getMaxStatementLength());
        System.out.println("SQL keywords: " + dbmd.getSQLKeywords());
        System.out.println("Numeric functions: " + dbmd.getNumericFunctions());
        System.out.println("String functions: " + dbmd.getStringFunctions());
        System.out.println("System functions: " + dbmd.getSystemFunctions());
        System.out.println("Supports full outer joins ?? :" + dbmd.supportsFullOuterJoins());
        System.out.println("Supports stored procedures ?? :" + dbmd.supportsStoredProcedures());
    }
}
