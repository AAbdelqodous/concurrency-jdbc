package q54;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "SELECT PROD_ID, NAME_AR, NAME_EN, UNIT, PRICE FROM PAM_DB.PRODUCT ORDER BY PROD_ID";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt =
//                        conn.createStatement();// same as conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY) -- // absolute, update/delete not working with it
//                        conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // update/delete not working with it
//                        conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ){
            var rs = stmt.executeQuery(query);
            rs.moveToInsertRow(); // conn.createStatement(ResultSet.TYPE_FORWARD_ONLY
            rs.updateInt(1, 5);
            rs.updateString(2, "One plus");
            rs.updateString(3, "1+");
            rs.updateString(4, "count");
            rs.updateDouble(5, 180);
//            rs.insertRow();
            rs.refreshRow(); // not working with conn.createStatement( ..., ResultSet.CONCUR_UPDATABLE);
            rs.updateRow();
            rs.last();
            System.out.println(rs.getInt(1));
        }
    }
}
