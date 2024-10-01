import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

// jdbc program to implement batch updates with simple statement object

class jdbcdurga30 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            st.addBatch("INSERT INTO employees(ename, esal, eaddr)VALUES('Vinni',4500,'Chennai')");
            st.addBatch("UPDATE employees SET esal = esal + 777 WHERE esal < 4000");
            st.addBatch("DELETE FROM employees WHERE esal >=5000");
//            st.addBatch("SELECT * FROM employees");
            int[] x = st.executeBatch();
            int updateCount = 0;
            for(int x1 : x){
                updateCount += x1;
            }
            System.out.println("The no of rows updated: " + updateCount);
            con.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
