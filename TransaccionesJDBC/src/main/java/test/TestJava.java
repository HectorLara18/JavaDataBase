package test;

import datos.PersonaDAO;
import domain.Usuario;
import java.util.*;

public class TestJava {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        Usuario usuario = new Usuario("Hector", "Lara");
        Usuario usuario2 = new Usuario("Jazmin", "Banda");
        Usuario usuario3 = new Usuario("Eduardo", "Salas");
        personaDAO.insertar(usuario);
        personaDAO.insertar(usuario2);
        personaDAO.insertar(usuario3);
        List<Usuario> usuarios = personaDAO.seleccionar();
        usuarios.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
