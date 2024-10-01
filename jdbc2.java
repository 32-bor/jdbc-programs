import  java.sql.*;

public class jdbc2
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Blessings@101";
        String query = "INSERT INTO employee(name,job_title,salary) VALUES('Ujjwal','React Developer',77000)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver class loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
            Statement st = con.createStatement();
            int x = st.executeUpdate(query);
            ResultSet rs = st.executeQuery("Select * from employee");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println(id);
                System.out.println(name);
                System.out.println(job_title);
                System.out.println(salary);
            }
            st.close();
            rs.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
