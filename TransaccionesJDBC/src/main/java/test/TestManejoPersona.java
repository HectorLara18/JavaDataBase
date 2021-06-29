package test;

import datos.PersonaDAO;
import domain.Conexion;
import domain.Usuario;
import java.util.*;

import java.sql.*;

public class TestManejoPersona {
    public static void main(String[] args) {

        Connection conexion = null;

        try{
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Usuario usuarioNuevo = new Usuario("Carlos", "Gutierres");
            List<Usuario> usuarioList;

            personaDAO.actualizar(8,"Jorge Luis", "Torres Alanis", true);
            personaDAO.insertar(usuarioNuevo);

            usuarioList = personaDAO.seleccionar();
            usuarioList.forEach(usuario -> {
                System.out.println("usuario = " + usuario);
            });

            conexion.commit();

        }catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Entramos a RollBack");
            try {
                conexion.rollback();
            }catch (SQLException ex2){
                ex2.printStackTrace(System.out);
            }
        }
    }
}
