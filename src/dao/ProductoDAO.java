package dao;

// @author

import conexionMySQL.ConexMySQL;
import interfaz.VentasInferface;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.ProductoTO;

public class ProductoDAO implements VentasInferface<ProductoTO>{

    @Override
    public ResultSet search(Object nombreBuscar) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String nombre = "%"+nombreBuscar+"%";
        String sql = "select * from v_producto where nomb_prod like ?";
        
        PreparedStatement pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        pst.setString(1, nombre);
        ResultSet rs = pst.executeQuery();
        return rs;
    }

    public ResultSet searchID(int id) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "select * from v_producto where id_producto = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        return rs;
    }
    
    @Override
    public void insert(ProductoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_insert_producto(?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setString(1, objItem.getNombProd());
        cst.setDouble(2, objItem.getPrecProd());
        cst.setString(3, objItem.getObsvProd());
        
        File objFile = new File(objItem.getFotoProd());
        FileInputStream objFileInputStream = new FileInputStream(objFile);
        cst.setBinaryStream(4, objFileInputStream);
        cst.execute();
    }

    @Override
    public void update(ProductoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_update_producto(?,?,?,?,?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdProducto());
        cst.setString(2, objItem.getNombProd());
        cst.setDouble(3, objItem.getPrecProd());
        cst.setString(4, objItem.getObsvProd());
        
        File objFile = new File(objItem.getFotoProd());
        if (objFile.exists()) {
            System.out.println("Existe");
            FileInputStream objFileInputStream = new FileInputStream(objFile);
            cst.setBinaryStream(5, objFileInputStream);
        } else {
            cst.setNull(5, java.sql.Types.BLOB);
        }
        cst.execute();
    }

    @Override
    public void delete(ProductoTO objItem) throws Exception {
        Connection con = ConexMySQL.getInstance().getConnection();
        String sql = "call sp_delete_producto(?)";
        CallableStatement cst = con.prepareCall(sql);
        cst.setInt(1, objItem.getIdProducto());
        cst.execute();
    }
}
