package test;

import java.sql.*;

public class TestInsert {
    public static void main(String[] args) {
        insertSQL("Raul","Lara", "rlaras@hexcam.com.mx", "8180507406");
    }

    public static void insertSQL(String nombre, String apellido, String mail, String telefono){
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        var query = "insert into persona(nombre, apellido, email, telefono) values('" + nombre + "','" + apellido + "','" + mail + "','" + telefono + "')";
        try{
            Connection conexion = DriverManager.getConnection(url, "root", "hlara2505");
            Statement instruccion = conexion.createStatement();
            int resultado = instruccion.executeUpdate(query);
            instruccion.close();
            conexion.close();
            System.out.println("Usuario creado en la base de datos");
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void imprimir(String nombre, String apellido, String mail, String telefono){
        var query = "insert into persona(nombre, apellido, correo, telefono) values('" + nombre + "','" + apellido + "','" + mail + "','" + telefono + "')";
        System.out.println(query);
    }
}
