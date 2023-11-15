package q73;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        var prop = new Properties();
        prop.put("user", "PAM_DB");
        prop.put("password", "PAM_DB2022");
        String query = "SELECT * FROM PAM_DB.PRODUCT ORDER BY PROD_ID";
//        Class.forName(url); //No harm, but expects fully qualified name of the class but in this case url refers to
        // database url and not fully qualified name of the clas
        try (
                var conn = DriverManager.getConnection(url, prop);
                var stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                var rs = stmt.executeQuery(query);
        ){
            rs.afterLast();
            rs.relative(-1);
            rs.previous();
            System.out.println(rs.getInt(1));
        } catch (SQLException e) {
            //System.out.println("An Error Occurred!");
            throw new RuntimeException(e);
        }
    }
}
