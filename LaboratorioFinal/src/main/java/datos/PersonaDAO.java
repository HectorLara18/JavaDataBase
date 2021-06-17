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

    private static final String SQL_SELECT = "SELECT id_usuario, nombre, apellido, isAha2505ctive from usuarios";
    private static final String SQL_INSERT = "";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";

    //Constructor

    public PersonaDAO(){};

    //Metodos

    public List<Usuario> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setActive(rs.getBoolean("isActive"));
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
}
