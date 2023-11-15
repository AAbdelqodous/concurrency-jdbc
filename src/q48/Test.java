package q48;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "SELECT PROD_ID, NAME_AR, UNIT, PRICE FROM PAM_DB.PRODUCT WHERE PRICE > 350 ORDER BY PROD_ID";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                var rs = stmt.executeQuery(query);
        ){
            rs.absolute(1);
            rs.updateDouble("PRICE", 20000);
            // to update the records in the database, `rs.updateRow();` statement must be invoked.
            // there is no need to invoke `con.commit();` method as by default Connection object is in auto-commit mode.
        } catch (SQLException e) {
            //System.out.println("An Error Occurred!");
            throw new RuntimeException(e);
        }
    }
}
