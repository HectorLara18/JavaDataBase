package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.List;


public class TestSQLException {
    public static void main(String[] args) {

        Connection conexion = null;
        try{
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Usuario usuarioNuevo = new Usuario("Jazmin", "Banda123456789Banda123456789Banda123456789Banda123456789");
            List<Usuario> usuarioList;

            personaDAO.eliminar(8);
            personaDAO.insertar(usuarioNuevo);

            usuarioList = personaDAO.seleccionar();
            usuarioList.forEach(usuario -> {
                System.out.println("usuario = " + usuario);
            });

            conexion.commit();

        }catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("se inicia proceso roll back");
            try{
                conexion.rollback();
            }catch (SQLException ex1){
                ex1.printStackTrace(System.out);
            }
        }
    }
}
