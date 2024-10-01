import java.sql.*;

// Program to drop a table

public class jdbcdurga2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String sql = "DROP TABLE employees";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Table deleted successfully");
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
