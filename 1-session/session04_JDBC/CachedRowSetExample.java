package DisconnectedRowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;


public class CachedRowSetExample {

    private static Connection cnn;
    private static final String serverName = "localhost";
    private static final String account = "sa";
    private static final String port = "1433";
    private static final String password = "123456";
    private static final String database = "TrackingAnimeDB";
    public static void main(String[] args) {
        String dbUrl = String.format("jdbc:sqlserver://%s:%s;trustServerCertificate=true;databaseName=%s", serverName, port, database);
        try {
            CachedRowSet crs =
                    RowSetProvider.newFactory().createCachedRowSet();
            crs.setUsername("sa"); crs.setPassword("123456");
            crs.setUrl(dbUrl);
            crs.setCommand("SELECT * FROM Notification");
            crs.execute();
            while (crs.next()) {
                System.out.println("noti No: "+crs.getInt(1));
            }
        } catch (SQLException se) {
            System.out.println("error: " + se.getMessage());
        }
    }
}

