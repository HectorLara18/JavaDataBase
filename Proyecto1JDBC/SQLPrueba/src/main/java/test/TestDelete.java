package test;

import Datos.PersonaDAO;
import Domain.Persona;
import java.util.*;

public class TestDelete {
    public static void main(String[] args) {
        //Persona persona = new Persona("Hector", "Lara", "hlaras@hexcam.com.mx","8180507010");
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.eliminar("jtorresa@hexcam.com.mx");
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
