/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import to.DetalleFacturaTO;

/**
 * @author
 */
public class DetalleFacturaDAO implements VentasInferface<DetalleFacturaTO>{

    @Override
    public ResultSet search(Object objItem) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(DetalleFacturaTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_detalle_factura(?,?,?,?,?)";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, objItem.getIdFactura());
        cs.setInt(2, objItem.getIdProducto());
        cs.setDouble(3, objItem.getPrecio());
        cs.setInt(4, objItem.getCantidad());
        cs.setDouble(5, objItem.getImporte());
        cs.execute();
    }

    @Override
    public void update(DetalleFacturaTO objItem) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(DetalleFacturaTO objItem) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
