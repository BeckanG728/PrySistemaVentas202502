package conexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexMySQL {

    private static ConexMySQL instance;
    
    

    private String url = "jdbc:mysql://localhost:3306/ventas202502?useSSL=false&serverTimezone=UTC";
    private String usuario = "root";
    private String clave = "";

    private ConexMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexMySQL getInstance() {
        if (instance == null) {
            instance = new ConexMySQL();
        }
        return instance;
    }

    // SIEMPRE devuelve una conexión nueva
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, usuario, clave);
    }
}