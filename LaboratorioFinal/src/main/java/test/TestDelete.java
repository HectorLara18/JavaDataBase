package test;

import datos.PersonaDAO;
import domain.Usuario;

import java.util.List;

public class TestDelete {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.eliminar(6);
        List<Usuario> usuarios = personaDAO.seleccionar();
        usuarios.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
