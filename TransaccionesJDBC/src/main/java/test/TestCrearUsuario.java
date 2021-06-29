package test;

import domain.Usuario;

public class TestCrearUsuario {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Hector", "Lara");
        System.out.println(usuario.crearUsuario());
    }
}
