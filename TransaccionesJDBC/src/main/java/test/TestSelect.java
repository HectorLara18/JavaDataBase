package test;

import datos.PersonaDAO;
import domain.Usuario;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Usuario> usuarios = personaDAO.seleccionar();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
    }
}
