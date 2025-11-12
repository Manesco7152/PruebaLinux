package Model;

import java.sql.Timestamp;

public class vendedores {
    int id_vendedor;
    int id_usuario;
    String nombre_tienda;
    String descripcion;
    String url_logo;
    Timestamp fecha_establecimiento;

    public vendedores() {}

    public vendedores(int id_vendedor, int id_usuario, String nombre_tienda, String descripcion, String url_logo, Timestamp fecha_establecimiento) {
        this.id_vendedor = id_vendedor;
        this.id_usuario = id_usuario;
        this.nombre_tienda = nombre_tienda;
        this.descripcion = descripcion;
        this.url_logo = url_logo;
        this.fecha_establecimiento = fecha_establecimiento;
    }
    public int getId_vendedor() {
        return id_vendedor;
    }
    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public Timestamp getFecha_establecimiento() {
        return fecha_establecimiento;
    }

    public void setFecha_establecimiento(Timestamp fecha_establecimiento) {
        this.fecha_establecimiento = fecha_establecimiento;
    }

    @Override
    public String toString() {
        return "vendedores [id_vendedor=" + id_vendedor + ", id_usuario=" + id_usuario + ", nombre_tienda=" + nombre_tienda + ", descripcion="
                + descripcion + ", url_logo=" + url_logo + ", fecha_establecimiento=" + fecha_establecimiento + "]";
    }
    
}