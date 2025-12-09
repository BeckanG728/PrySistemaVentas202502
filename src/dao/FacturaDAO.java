/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.sql.*;
import to.FacturaTO;

/**
 * @author
 */
public class FacturaDAO implements VentasInferface<FacturaTO> {

    @Override
    public ResultSet search(Object objItem) throws Exception {
        return null;
    }

    @Override
    public void insert(FacturaTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_factura(?,?,?,?,?)";
        CallableStatement cs = con.prepareCall(sql);
        cs.setInt(1, objItem.getIdCliente());
        cs.setInt(2, objItem.getIdEmpleado());
        cs.setDouble(3, objItem.getStotFact());
        cs.setDouble(4, objItem.getIgvFact());
        cs.setDouble(5, objItem.getTotaFact());
        cs.execute();
    }

    public int obtenerIdFactura() throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "SELECT id_factura FROM factura ORDER BY id_factura DESC LIMIT 1";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new Exception("No existen facturas registradas.");
        }
    }

    @Override
    public void update(FacturaTO objItem) throws Exception {

    }

    @Override
    public void delete(FacturaTO objItem) throws Exception {

    }

}
