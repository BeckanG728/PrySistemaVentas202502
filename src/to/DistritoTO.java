package to;

// @author
public class DistritoTO {

    private int idDistrito;
    private String nombDist;
    private String obsvDist;

    public DistritoTO() {
    }

    public DistritoTO(int idDistrito, String nombDist, String obsvDist) {
        this.idDistrito = idDistrito;
        this.nombDist = nombDist;
        this.obsvDist = obsvDist;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombDist() {
        return nombDist;
    }

    public void setNombDist(String nombDist) {
        this.nombDist = nombDist;
    }

    public String getObsvDist() {
        return obsvDist;
    }

    public void setObsvDist(String obsvDist) {
        this.obsvDist = obsvDist;
    }
}
