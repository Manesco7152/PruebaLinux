package Model;

public class direccion {
    private int idDireccion;
    private int idUsuario;
    private String calle;
    private int numeroExterior;
    private int numeroInterior;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String pais;

    public direccion(){}

    public direccion(int idDireccion, int idUsuario, String calle, int numeroExterior, int numeroInterior, String colonia, String codigoPostal, String ciudad, String estado, String pais) {
        this.idDireccion = idDireccion;
        this.idUsuario = idUsuario;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
    }
    
    public int getIdDireccion() {
        return idDireccion;
    }
    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumeroExterior() {
        return numeroExterior;
    }
    public void setNumeroExterior(int numeroExterior) {
        this.numeroExterior = numeroExterior;
    }
    public int getNumeroInterior() {
        return numeroInterior;
    }
    public void setNumeroInterior(int numeroInterior) {
        this.numeroInterior = numeroInterior;
    }
    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    @Override
    public String toString() {
        return "direccion [idDireccion=" + idDireccion + ", idUsuario=" + idUsuario + ", calle=" + calle
                + ", numeroExterior=" + numeroExterior + ", numeroInterior=" + numeroInterior + ", colonia=" + colonia
                + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + ", estado=" + estado + ", pais=" + pais
                + "]";
    }

}
