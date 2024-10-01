import java.sql.*;

// Program to create a table in MySQL

public class jdbcdurga1 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String sql = "CREATE TABLE employees(id INT PRIMARY KEY AUTO_INCREMENT" +
                ", ename VARCHAR(255),esal INT,eaddr VARCHAR(255))";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Table created successfully");
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
