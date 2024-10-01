import java.sql.*;

// program to demonstrate updateable resultset and delete operation

public class jdbcdurga51 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        String sql = "SELECT * FROM employees";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery(sql);
        rs.insertRow();
//        rs.updateInt(1,10);
    }
}
