package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private Properties properties;

    public JdbcUtils(Properties properties) {
        this.properties = properties;
    }
    private static Connection instance = null;
    private Connection getNewConnection(){
        String driver=properties.getProperty("jdbc.driver");
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String pass=properties.getProperty("jdbc.pass");
        Connection con=null;
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver "+e);
        } catch (SQLException e) {
            System.out.println("Error getting connection "+e);
        }
        return con;
    }

    public Connection getConnection(){
        try {
            if (instance==null || instance.isClosed())
                instance=getNewConnection();
        } catch (SQLException e) {
            System.out.println("Error DB "+e);
        }
        return instance;
    }
}
