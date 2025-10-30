package dao;

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.DistritoTO;

public class DistritoDAO implements VentasInferface<DistritoTO>{

    @Override
    public ResultSet search(Object nombreBuscar) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String nombre = "%"+nombreBuscar+"%";
        String sql = "select * from v_distrito where nomb_dist like ?";
        PreparedStatement pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        pst.setString(1, nombre);
        ResultSet rsDistrito = pst.executeQuery();
        
        return rsDistrito;
    }

    @Override
    public void insert(DistritoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_distrito(?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, objItem.getNombDist());
        cst.setString(2, objItem.getObsvDist());
        cst.execute();
    }

    @Override
    public void update(DistritoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_update_distrito(?,?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdDistrito());
        cst.setString(2, objItem.getNombDist());
        cst.setString(3, objItem.getObsvDist());
        cst.execute();
    }

    @Override
    public void delete(DistritoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_delete_distrito(?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdDistrito());
        cst.execute();
    }

}
