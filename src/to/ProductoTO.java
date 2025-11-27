package to;

// @author
public class ProductoTO {

    private int idProducto;
    private String nombProd;
    private Double precProd;
    private String obsvProd;
    private String fotoProd;

    public ProductoTO() {
    }

    public ProductoTO(int idProducto, String nombProd, Double precProd, String obsvProd) {
        this.idProducto = idProducto;
        this.nombProd = nombProd;
        this.precProd = precProd;
        this.obsvProd = obsvProd;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombProd() {
        return nombProd;
    }

    public void setNombProd(String nombProd) {
        this.nombProd = nombProd;
    }

    public Double getPrecProd() {
        return precProd;
    }

    public void setPrecProd(Double precProd) {
        this.precProd = precProd;
    }

    public String getObsvProd() {
        return obsvProd;
    }

    public void setObsvProd(String obsvProd) {
        this.obsvProd = obsvProd;
    }

    public String getFotoProd() {
        return fotoProd;
    }

    public void setFotoProd(String fotoProd) {
        this.fotoProd = fotoProd;
    }

}
