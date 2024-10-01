import  java.sql.*;

public class jdbc1
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Blessings@101";
        String query = "SELECT * FROM employee";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connected successfully");
            System.out.println();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                Double salary = rs.getDouble("salary");
                System.out.println(id);
                System.out.println(name);
                System.out.println(job_title);
                System.out.println(salary);
                System.out.println();
            }
            rs.close();
            st.close();
            con.close();
            System.out.println("connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
