package q43;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "SELECT * FROM PAM_DB.PRODUCT";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt =
//                        conn.createStatement();
                        conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                        conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT)
                var rs = stmt.executeQuery(query) ;
        ){
            System.out.println(rs.getMetaData());
            System.out.println("----------------- before while ----------------");
            System.out.println("rs has next: " +rs.next());
            while (rs.next()){
                System.out.println("----------------- rs.next() ----------------");
                System.out.println("ID: " + rs.getInt("IDD")); //wrong column name but this statement is not executed
                System.out.println("AR. NAME: " + rs.getString("NAME_AR"));
                System.out.println("EN. NAME: " + rs.getString("NAME_AR"));
                System.out.println("PRICE: " + rs.getDouble("PRICE"));
            }
        } catch (SQLException e) {
            //System.out.println("An Error Occurred!");
            throw new RuntimeException(e);
        }
    }
}
