package Model;

public class direcciones {
    int id_direccion;
    int id_usuario;
    String calle;
    String numero_exterior;
    String numero_interior;
    String colonia;
    String codigo_postal;
    String ciudad;
    String estado;
    String pais;

    public direcciones() {}

    public direcciones(int id_direccion, int id_usuario, String calle, String numero_exterior, String numero_interior, String colonia, String codigo_postal, String ciudad, String estado, String pais) {
        this.id_direccion = id_direccion;
        this.id_usuario = id_usuario;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interior = numero_interior;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
    }
    public int getId_direccion() {
        return id_direccion;
    }
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(String numero_interior) {
        this.numero_interior = numero_interior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
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
        return "direcciones [id_direccion=" + id_direccion + ", id_usuario=" + id_usuario + ", calle=" + calle
                + ", numero_exterior=" + numero_exterior + ", numero_interior=" + numero_interior + ", colonia="
                + colonia + ", codigo_postal=" + codigo_postal + ", ciudad=" + ciudad + ", estado=" + estado + ", pais="
                + pais + "]";
    }
    
}
