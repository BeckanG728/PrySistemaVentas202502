/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.sql.*;
import to.ClienteTO;

/**
 * @author
 */
public class ClienteDAO implements VentasInferface<ClienteTO>{

    @Override
    public ResultSet search(Object objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String nombre = "%" + objItem + "%";
        String sql = "select * from v_cliente where nomb_clie like ?";
        PreparedStatement pst = con.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        pst.setString(1, nombre);
        ResultSet rs = pst.executeQuery();

        return rs;
    }

    @Override
    public void insert(ClienteTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_cliente(?,?,?,?,?,?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);

        cst.setString(1, objItem.getRuc());
        cst.setString(2, objItem.getNombre());
        cst.setString(3, objItem.getDireccion());
        cst.setInt(4, objItem.getIdDistrito());
        cst.setString(5, objItem.getTelefono());
        cst.setString(6, objItem.getCelular());
        cst.setString(7, objItem.getEmail());
        cst.setString(8, objItem.getObservacion());
        cst.execute();
    }

    @Override
    public void update(ClienteTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_update_cliente(?,?,?,?,?,?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);

        cst.setInt(1, objItem.getIdCliente());
        cst.setString(2, objItem.getRuc());
        cst.setString(3, objItem.getNombre());
        cst.setString(4, objItem.getDireccion());
        cst.setInt(5, objItem.getIdDistrito());
        cst.setString(6, objItem.getTelefono());
        cst.setString(7, objItem.getCelular());
        cst.setString(8, objItem.getEmail());
        cst.setString(9, objItem.getObservacion());

        cst.execute();
    }

    @Override
    public void delete(ClienteTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_delete_cliente(?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdCliente());

        cst.execute();
    }

}
