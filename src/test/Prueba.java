package test;

// @author
import dao.EmpleadoDAO;
import dao.ProductoDAO;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Arrays;

public class Prueba {

    public static void main(String[] args) {
        ResultSet rsDistrito;
        try {
            EmpleadoDAO dao = new EmpleadoDAO();
            rsDistrito = dao.search("o");
            while(rsDistrito.next()){
                
                Object [] distrito = {rsDistrito.getInt(1),rsDistrito.getString(2)};
                System.out.println(Arrays.toString(distrito));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion: "+e.getMessage());
        }
    }
}
