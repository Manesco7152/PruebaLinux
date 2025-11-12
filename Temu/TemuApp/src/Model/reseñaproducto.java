package Model;

public class reseñaproducto {
    private int idResena;
    private int idUsuario;
    private int idProducto;
    private String calificacion;
    private String comentario;
    private String fechaResena;

    public reseñaproducto (){}

    public reseñaproducto(int idResena, int idUsuario, int idProducto, String calificacion, String comentario,String fechaResena) {
        this.idResena = idResena;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
    }

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(String fechaResena) {
        this.fechaResena = fechaResena;
    }

    @Override
    public String toString() {
        return "reseñaproducto [idResena=" + idResena + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto
                + ", calificacion=" + calificacion + ", comentario=" + comentario + ", fechaResena=" + fechaResena
                + "]";
    }
}
