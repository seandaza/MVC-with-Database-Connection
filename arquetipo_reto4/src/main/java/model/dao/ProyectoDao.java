package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para SQL y Base de Datos
//import java.sql.SQLException;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

public class ProyectoDao {

    public ArrayList<Proyecto> query_requerimiento_1() throws Exception {

        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas  
        try {
            //Ejecuta el query
            ResultSet query = conexion.createStatement().executeQuery("SELECT Fecha_Inicio, Numero_Habitaciones, Numero_Banos FROM Proyecto WHERE Constructora = 'Pegaso'");
            //Recorre los resultados del query
            while (query.next()) {
                //Almacena los resultados del query en un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(query.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(query.getInt("Numero_Habitaciones"));
                objProyecto.setNum_banios(query.getInt("Numero_Banos"));
                // Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return proyectos;
        


    }

    public ArrayList<Proyecto> query_requerimiento_2() throws Exception {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecuta el query
            ResultSet query = conexion.createStatement().executeQuery("SELECT p.Fecha_Inicio, p.Numero_Habitaciones, p.Numero_Banos, l.Nombre, l.Primer_Apellido, t.Estrato FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider INNER JOIN Tipo t ON t.ID_Tipo = p.ID_Tipo WHERE Constructora = 'Pegaso' LIMIT 50");
            //Recorre los resultados del query
            while (query.next()) {
                //Almacena los resultados del query en un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setFecha_inicio(query.getString("Fecha_Inicio"));
                objProyecto.setNum_habitaciones(query.getInt("Numero_Habitaciones"));
                objProyecto.setNum_banios(query.getInt("Numero_Banos"));
                objProyecto.setEstrato_proyecto(query.getInt("Estrato"));
                //Crea objeto lider
                String nombre_lider = query.getString("Nombre");
                String apellido_lider = query.getString("Primer_Apellido");
                Lider objLider = new Lider(nombre_lider, apellido_lider);
                objProyecto.setLider(objLider);
                // Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return proyectos;
        
        
    }// Fin del método query_requerimiento_2


    public ArrayList<Proyecto> query_requerimiento_3() throws Exception {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecuta el query
            ResultSet query = conexion.createStatement().executeQuery("SELECT SUM(Numero_Habitaciones) as Total_Habitaciones, Constructora FROM Proyecto p GROUP BY Constructora");
            //Recorre los resultados del query
            while (query.next()) {
                //Almacena los resultados del query en un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_habitaciones(query.getInt("Total_Habitaciones"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                // Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return proyectos;
    }// Fin del método query_requerimiento_3


    public ArrayList<Proyecto> query_requerimiento_5() throws Exception{
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        //Consultas
        try {
            //Ejecuta el query
            ResultSet query = conexion.createStatement().executeQuery("SELECT SUM(Numero_Habitaciones) as Total_Habitaciones, Constructora FROM Proyecto p GROUP BY Constructora HAVING Total_Habitaciones > 200.0 ORDER BY Total_Habitaciones");
            //Recorre los resultados del query
            while (query.next()) {
                //Almacena los resultados del query en un objeto Proyecto
                Proyecto objProyecto = new Proyecto();
                objProyecto.setNum_habitaciones(query.getInt("Total_Habitaciones"));
                objProyecto.setNombre_constructora(query.getString("Constructora"));
                // Agrega el objeto al arraylist
                proyectos.add(objProyecto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return proyectos;
        
    }// Fin del método query_requerimiento_4

}