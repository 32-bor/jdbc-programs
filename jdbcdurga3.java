import java.sql.*;

// Program to insert data into table

public class jdbcdurga3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String sql = "INSERT INTO employees(ename,esal,eaddr)VALUES(" + "'" +
                "durga" +"'," + 1000 + ",'" + "hyderabad" +"')";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            int affectedRows = st.executeUpdate(sql);

            if(affectedRows>0){
                System.out.println("Insertion completed successfully");
            }else{
                System.out.println("Insertion failed");
            }

//            while(rs.next()){
//                int number = rs.getInt("eno");
//                String name = rs.getString("ename");
//                int salary = rs.getInt("esal");
//                String address = rs.getString("eaddr");
//                System.out.println("Employee ID: "+number);
//                System.out.println("Employee name: "+name);
//                System.out.println("Employee salary: "+salary);
//                System.out.println("Employee address: "+address);
//            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
