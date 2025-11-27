package conexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;

// @author
public class ConexMySQL {

    private static ConexMySQL instance = null;
    private Connection connection = null;

    public ConexMySQL() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/ventas202502";
        String usuario = "root";
        String clave = "";

        connection = DriverManager.getConnection(url, usuario, clave);
    }

    public static ConexMySQL getInstance() throws Exception {
        return (instance == null) ? new ConexMySQL() : instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        connection = null;
        super.finalize();
    }

}
