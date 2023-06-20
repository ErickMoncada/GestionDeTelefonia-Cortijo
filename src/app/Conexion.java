package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ErickMoncada Clase para la conexion con la base de datos
 */
public class Conexion {

    public static Connection getConexion() {
        String url = "jdbc:sqlserver://localhost:1433;database=Telefonia_Cortijo1.1;user=sa;password=123;encrypt=true;trustServerCertificate=true";
        try {
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
