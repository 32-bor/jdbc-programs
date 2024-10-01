import java.sql.*;

// program to iterate in both forward and backward directions using scrollable resultset

public class jdbcdurga50 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM employees");
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Results in forward direction");
        System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3)+"\t"+rsmd.getColumnName(4));
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        }
        System.out.println("Results in backward direction");
        System.out.println("========================================================================");
        System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3)+"\t"+rsmd.getColumnName(4));
        while (rs.previous()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        }

        System.out.println("=========================================================================");

        rs.first();
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));

        rs.last();
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));

        rs.relative(-1);
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        rs.absolute(2);
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
        System.out.println(rs.isAfterLast());
    }
}
