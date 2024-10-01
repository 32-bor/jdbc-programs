import java.sql.*;

// program to parameter meta information by using parameter meta data

public class jdbcdurga48 {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/JDBC_Durga";
        String username = "root";
        String password = "Blessings@101";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pst = con.prepareStatement("INSERT INTO employees(ename,esal,eaddr)VALUES(?,?,?)");
        ParameterMetaData pmd = pst.getParameterMetaData();

        int count = pmd.getParameterCount();
        for(int i=1;i<=count;i++){
            System.out.println("Parameter number: " + i);
            System.out.println("Parameter mode: " + pmd.getParameterMode(i));
            System.out.println("Parameter type: " + pmd.getParameterType(i));
//            System.out.println("Parameter precision: " + pmd.getPrecision(i));
//            System.out.println("Parameter scale: " + pmd.getScale(i));
//            System.out.println("Parameter isSigned: " + pmd.isSigned(i));
//            System.out.println("Parameter isNullable: " + pmd.isNullable(i));
            System.out.println("============================");
        }
        con.close();
    }
}
