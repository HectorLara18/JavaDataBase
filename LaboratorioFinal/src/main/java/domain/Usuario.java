package domain;

public class Usuario {
    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellido;
    private boolean isActive;


    //Constyructos
    public Usuario(){};

    public Usuario(int idUsuario,String nombre, String apellido, boolean isActive){
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        isActive = true;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
