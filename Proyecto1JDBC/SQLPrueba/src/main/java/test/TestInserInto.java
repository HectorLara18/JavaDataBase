package test;

import Datos.PersonaDAO;
import Domain.*;

import java.util.List;

public class TestInserInto {
    public static void main(String[] args) {
        Persona persona = new Persona("Jorge","Torres", "jtorresa@hexcam.com.mx","8121507411");
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.Insertar(persona);
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(persona1 -> {
            System.out.println("persona1 = " + persona1);
        });
    }
}
