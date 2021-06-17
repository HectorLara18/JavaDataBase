package test;

import datos.PersonaDAO;
import domain.Usuario;
import java.util.*;

public class TestUpdate {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.actualizar(1,"Hector","Lara",true);
        List<Usuario> usuarios = personaDAO.seleccionar();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
    }
}
