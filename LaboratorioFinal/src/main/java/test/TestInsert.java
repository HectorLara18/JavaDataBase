package test;

import datos.PersonaDAO;
import domain.Usuario;

import java.util.List;

public class TestInsert {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Raul", "Lara");
        PersonaDAO personaDAO = new PersonaDAO();
        List<Usuario> usuarios;
        personaDAO.insertar(usuario);
        usuarios = personaDAO.seleccionar();
        usuarios.forEach(personas -> {
            System.out.println("Usuario: " + personas);
        });
    }
}
