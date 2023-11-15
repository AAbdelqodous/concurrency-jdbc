package q51;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "SELECT PROD_ID, NAME_AR, UNIT, PRICE FROM PAM_DB.PRODUCT ORDER BY PROD_ID";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt =
//                        conn.createStatement();// same as conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY) -- // absolute not working with it
//                        conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // update/delete not working with it
                        conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                var rs = stmt.executeQuery(query);
        ){
            rs.absolute(3); // not working with conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ..);
            rs.relative(-1);
            rs.deleteRow(); // not working with  conn.createStatement( .., ResultSet.CONCUR_READ_ONLY);
        }
    }
}
