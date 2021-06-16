package test;

import Datos.PersonaDAO;
import Domain.Persona;
import java.util.*;

import java.util.ArrayList;

public class TestUpdate {
    public static void main(String[] args) {
        Persona persona = new Persona("Hector", "Lara", "hlaras@hexcam.com.mx","8180507010");
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.actualizar(1,"Hector", "Lara", "hlaras@hexcam.com.mx","8180507010");
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(empleado -> {
            System.out.println("persona = " + empleado);
        });
    }
}
