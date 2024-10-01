import  java.sql.*;

public class jdbc4
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Blessings@101";
        String query = "UPDATE employee SET job_title = 'FullStack Java Developer', salary = '90000' WHERE id = 2";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver class loaded successfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int rowsaffected = st.executeUpdate(query);
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            if(rowsaffected>0)
                System.out.println("Operation successful");
            else
                System.out.println("operation failed");

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println(id);
                System.out.println(name);
                System.out.println(job_title);
                System.out.println(salary);
                System.out.println();
            }
            st.close();
            rs.close();
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
