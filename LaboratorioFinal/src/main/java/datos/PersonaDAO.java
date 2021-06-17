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
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";

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
}
