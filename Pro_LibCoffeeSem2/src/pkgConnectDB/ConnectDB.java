package pkgConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ng1an
 */
public class ConnectDB {
    static public String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static public String DB_URL = "jdbc:sqlserver://localhost:1433;";
    static public String DATABASENAME = "databasename=Coffee;";
    static public String USER = "user=sa;";
    static public String PASS = "password=123456";
    static public Connection conn;
    
    public static Connection connectData(){
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
  
  
}
