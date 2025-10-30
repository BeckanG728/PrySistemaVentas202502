
package to;

/**
 * @author
 */
public class EmpleadoTO {
    private int idEmpleado;
    private String nombEmpl;
    private String apatEmpl;
    private String amatEmpl;
    private String sexoEmpl;
    private String direEmpl;
    private int idDistrito;
    private String telfEmpl;
    private String celuEmpl;
    private String emailEmpl;
    private String obsEmpl;
    private String fotoEmpl;

    public EmpleadoTO() {
    }

    public EmpleadoTO(int idEmpleado, String nombEmpl, String apatEmpl, String amatEmpl, 
            String sexoEmpl, String direEmpl, int idDistrito, String telfEmpl, String celuEmpl, 
            String emailEmpl, String obsEmpl, String fotoEmpl) {
        this.idEmpleado = idEmpleado;
        this.nombEmpl = nombEmpl;
        this.apatEmpl = apatEmpl;
        this.amatEmpl = amatEmpl;
        this.sexoEmpl = sexoEmpl;
        this.direEmpl = direEmpl;
        this.idDistrito = idDistrito;
        this.telfEmpl = telfEmpl;
        this.celuEmpl = celuEmpl;
        this.emailEmpl = emailEmpl;
        this.obsEmpl = obsEmpl;
        this.fotoEmpl = fotoEmpl;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombEmpl() {
        return nombEmpl;
    }

    public void setNombEmpl(String nombEmpl) {
        this.nombEmpl = nombEmpl;
    }

    public String getApatEmpl() {
        return apatEmpl;
    }

    public void setApatEmpl(String apatEmpl) {
        this.apatEmpl = apatEmpl;
    }

    public String getAmatEmpl() {
        return amatEmpl;
    }

    public void setAmatEmpl(String amatEmpl) {
        this.amatEmpl = amatEmpl;
    }

    public String getSexoEmpl() {
        return sexoEmpl;
    }

    public void setSexoEmpl(String sexoEmpl) {
        this.sexoEmpl = sexoEmpl;
    }

    public String getDireEmpl() {
        return direEmpl;
    }

    public void setDireEmpl(String direEmpl) {
        this.direEmpl = direEmpl;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getTelfEmpl() {
        return telfEmpl;
    }

    public void setTelfEmpl(String telfEmpl) {
        this.telfEmpl = telfEmpl;
    }

    public String getCeluEmpl() {
        return celuEmpl;
    }

    public void setCeluEmpl(String celuEmpl) {
        this.celuEmpl = celuEmpl;
    }

    public String getEmailEmpl() {
        return emailEmpl;
    }

    public void setEmailEmpl(String emailEmpl) {
        this.emailEmpl = emailEmpl;
    }

    public String getObsEmpl() {
        return obsEmpl;
    }

    public void setObsEmpl(String obsEmpl) {
        this.obsEmpl = obsEmpl;
    }

    public String getFotoEmpl() {
        return fotoEmpl;
    }

    public void setFotoEmpl(String fotoEmpl) {
        this.fotoEmpl = fotoEmpl;
    }
    
    
}
