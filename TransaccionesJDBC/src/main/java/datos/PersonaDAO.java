package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import domain.*;
import static domain.Conexion.*;

public class PersonaDAO {
    //Atributos

    private static final String SQL_SELECT = "SELECT id_usuarios, nombre, apellido, isActive from usuarios";
    private static final String SQL_INSERT = "insert into usuarios(nombre,apellido,isActive) values(?,?,?)";
    private static final String SQL_UPDATE = "update usuarios set nombre = ?, apellido = ?, isActive = ? where id_usuarios = ?";
    private static final String SQL_DELETE = "delete from usuarios where id_usuarios = ?";

    //Constructor

    public PersonaDAO(){};

    //Metodos

    public List<Usuario> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPersona = rs.getInt("id_usuarios");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                boolean isActive = rs.getBoolean("isActive");
                usuario = new Usuario(idPersona,nombre,apellido,isActive);
                usuarios.add(usuario);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insertar(Usuario usuario){
        int resultado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setBoolean(3, usuario.isActive());
            resultado = stmt.executeUpdate();
            System.out.println("Usuario agregado a la base de datos");
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            }catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public int actualizar(int id_usuario, String nombre, String apellido, boolean isActive){
        int resultado = 0;
        var usuario = new Usuario(id_usuario,nombre,apellido,isActive);
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setBoolean(3, usuario.isActive());
            stmt.setInt(4,usuario.getIdUsuario());
            resultado = stmt.executeUpdate();
            System.out.println("Se modifico el usuario");
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally {
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    public int eliminar(int idUsuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int resultado = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,idUsuarios);
            resultado = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally {
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

}
