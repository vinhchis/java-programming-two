package DisconnectedRowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ResultSetToChedRowSetExample {
    private static Connection cnn;
    private static final String serverName = "localhost";
    private static final String account = "sa";
    private static final String port = "1433";
    private static final String password = "123456";
    private static final String database = "TrackingAnimeDB";

    public static void main(String[] args) {
        String dbUrl = String.format("jdbc:sqlserver://%s:%s;trustServerCertificate=true;databaseName=%s", serverName, port, database);
        try{
            // Register JDBC driver
            cnn = DriverManager.getConnection(dbUrl, account, password);
            System.out.println("Connection Successfully");
        }catch(SQLException err){
            System.err.println("Connection Fail! " + err.getMessage());
            err.printStackTrace();
        }


        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSet crs = null;
        String query = "SELECT * FROM Notification";


        try {

            crs = RowSetProvider.newFactory().createCachedRowSet();
            stmt = cnn.createStatement();
            rs = stmt.executeQuery(query);
            crs.populate(rs);
            cnn.close();

            while (crs.next()) {
                System.out.println("noti No: "+crs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
