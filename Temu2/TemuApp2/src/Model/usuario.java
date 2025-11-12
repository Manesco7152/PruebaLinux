package Model;

import java.sql.Timestamp;

public class usuario {
    int id_usuario;
    String nombre_usuario;
    String correo_electronico;
    String contraseña;
    Timestamp fecha_registro;
    Timestamp ultimo_acceso;
    String rol;

    public usuario() {}

    public usuario(int id_usuario, String nombre_usuario, String correo_electronico, String contraseña, Timestamp fecha_registro, Timestamp ultimo_acceso, String rol) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.correo_electronico = correo_electronico;
        this.contraseña = contraseña;
        this.fecha_registro = fecha_registro;
        this.ultimo_acceso = ultimo_acceso;
        this.rol = rol;
    }
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre) {
        this.nombre_usuario = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Timestamp getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Timestamp ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", correo_electronico="
                + ", contraseña=" + contraseña + ", fecha_registro=" + fecha_registro + ", ultimo_acceso="
                + ultimo_acceso + ", rol=" + rol + "]";
    }
    
}
