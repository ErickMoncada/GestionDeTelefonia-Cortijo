package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ErickMoncada Clase para la conexion con la base de datos
 */
public class Conexion {
    
    public static Connection getConexion() {
        Properties properties = ConfigReader.getProperties();
        String direccion = properties.getProperty("db.direccion");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String database = properties.getProperty("db.database");
        String url = "jdbc:sqlserver:"+direccion+";database="+database+";user="+username+";password="+password+";encrypt=true;trustServerCertificate=true";
        try {
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
