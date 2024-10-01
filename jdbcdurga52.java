import javax.sql.*;
import javax.sql.rowset.*;
import java.sql.SQLException;

// types of rowsets and how to get their implementation class names

public class jdbcdurga52 {
    public static void main(String[] args) throws SQLException {

        RowSetFactory rsf = RowSetProvider.newFactory();
        CachedRowSet crs = rsf.createCachedRowSet();
        WebRowSet wrs = rsf.createWebRowSet();
        FilteredRowSet frs = rsf.createFilteredRowSet();
        JdbcRowSet jrs = rsf.createJdbcRowSet();
        JoinRowSet jnrs = rsf.createJoinRowSet();

        System.out.println(rsf.getClass().getName());
        System.out.println(crs.getClass().getName());
        System.out.println(wrs.getClass().getName());
        System.out.println(frs.getClass().getName());
        System.out.println(jrs.getClass().getName());
        System.out.println(jnrs.getClass().getName());
    }
}
