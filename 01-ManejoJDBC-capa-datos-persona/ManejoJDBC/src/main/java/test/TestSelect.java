package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;

public class TestSelect {
    public static void main(String[] args) {
        PersonaDaoJDBC persona = new PersonaDaoJDBC();
        List<PersonaDTO> usuarios;
        try{
            usuarios = persona.select();
            usuarios.forEach(usuario -> {
                System.out.println("usuario = " + usuario);
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
