package dao;

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.EmpleadoTO;

public class EmpleadoDAO implements VentasInferface<EmpleadoTO> {

    @Override
    public ResultSet search(Object objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String nombre = "%" + objItem + "%";
        String sql = "select * from v_empleado where apat_empl like ?";
        PreparedStatement pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        pst.setString(1, nombre);
        ResultSet rsDistrito = pst.executeQuery();

        return rsDistrito;
    }
    
    
    public ResultSet searchID(int id) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "select * from v_empleado where id_empleado = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        return rs;
    }

    @Override
    public void insert(EmpleadoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_empleado(?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, objItem.getNombEmpl());
        cst.setString(2, objItem.getApatEmpl());
        cst.setString(3, objItem.getAmatEmpl());
        cst.setString(4, objItem.getSexoEmpl());
        cst.setString(5, objItem.getDireEmpl());
        cst.setInt(6, objItem.getIdDistrito());
        cst.setString(7, objItem.getTelfEmpl());
        cst.setString(8, objItem.getCeluEmpl());
        cst.setString(9, objItem.getEmailEmpl());
        cst.setString(10, objItem.getObsEmpl());
        
        File objFile = new File(objItem.getFotoEmpl());
        FileInputStream objFileInputStream = new FileInputStream(objFile);
        cst.setBinaryStream(11, objFileInputStream);

        cst.execute();
    }

    @Override
    public void update(EmpleadoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_update_empleado(?,?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdEmpleado());
        cst.setString(2, objItem.getNombEmpl());
        cst.setString(3, objItem.getApatEmpl());
        cst.setString(4, objItem.getAmatEmpl());
        cst.setString(5, objItem.getSexoEmpl());
        cst.setString(6, objItem.getDireEmpl());
        cst.setInt(7, objItem.getIdDistrito());
        cst.setString(8, objItem.getTelfEmpl());
        cst.setString(9, objItem.getCeluEmpl());
        cst.setString(10, objItem.getEmailEmpl());
        cst.setString(11, objItem.getObsEmpl());
        
        File objFile = new File(objItem.getFotoEmpl());
        if (objFile.exists()) {
            System.out.println("Existe");
            FileInputStream objFileInputStream = new FileInputStream(objFile);
            cst.setBinaryStream(12, objFileInputStream);
        } else {
            cst.setNull(12, java.sql.Types.BLOB);
        }
        cst.execute();
    }

    @Override
    public void delete(EmpleadoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_delete_empleado(?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdEmpleado());
        cst.execute();
    }

}
