
import java.sql.*;

// program to column meta information by using result set meta data

public class jdbcdurga47 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");
        ResultSetMetaData rsmd = rs.getMetaData();

        String col1 = rsmd.getColumnName(1);
        String col2 = rsmd.getColumnName(2);
        String col3 = rsmd.getColumnName(3);
        String col4 = rsmd.getColumnName(4);
        System.out.println(col1 +"\t"+col2+"\t"+col3+"\t"+col4);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        }
        con.close();
    }
}
