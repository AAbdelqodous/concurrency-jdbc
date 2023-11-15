package q48;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FillTable {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//hyper-v2k19.manpower.gov.kw:1521/T27JUN22";
        String userName = "PAM_DB";
        String password = "PAM_DB2022";
        String query = "INSERT INTO PAM_DB.PRODUCT VALUES(?, ?, ?, ?, ?)";
        try (
                var conn = DriverManager.getConnection(url, userName, password);
                var stmt = conn.prepareStatement(query);
        ){
            stmt.setInt(1, 4);
            stmt.setString(2, "Google Pixel 8 Pro");
            stmt.setString(3, "Google Pixel 8 Pro");
            stmt.setString(4, "Count");
            stmt.setDouble(5, 420);
            stmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println("An Error Occurred!");
            throw new RuntimeException(e);
        }
    }
}
