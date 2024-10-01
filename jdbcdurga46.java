import java.sql.*;

// program to column meta information by using result set meta data

public class jdbcdurga46 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");
        ResultSetMetaData rsmd = rs.getMetaData();

        int count = rsmd.getColumnCount();
        for(int i=1;i<=count;i++){
            System.out.println("Column number: " + i);
            System.out.println("Comumn name: " + rsmd.getColumnName(i));
            System.out.println("Column type: " + rsmd.getColumnType(i));
            System.out.println("Column display size: " + rsmd.getColumnDisplaySize(i));
            System.out.println("===============");
        }
        con.close();
    }
}
