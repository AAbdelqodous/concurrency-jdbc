package q50;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "SELECT PROD_ID, NAME_AR, UNIT, PRICE FROM PAM_DB.PRODUCT ORDER BY PROD_ID";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                var rs = stmt.executeQuery(query);
        ){
            rs.absolute(-2);
            rs.relative(-1);
            System.out.println(rs.getString(2));
            System.out.println(rs.getDouble(4));
        } catch (SQLException e) {
            //System.out.println("An Error Occurred!");
            throw new RuntimeException(e);
        }
    }
}
