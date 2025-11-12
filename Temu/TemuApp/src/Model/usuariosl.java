package Model;

public class usuariosl{
    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String correo;

    public usuariosl(int idUsuario, String nombreUsuario, String contraseña, String correo) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "usuariosl [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
                + ", correo=" + correo + "]";
    }

}
