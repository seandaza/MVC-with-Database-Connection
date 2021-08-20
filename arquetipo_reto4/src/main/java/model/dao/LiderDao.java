package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
//import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws Exception {
        Connection conexion = JDBCUtilities.getConnection();
        // Crea arreglo para almacenar objetos tipo Lider
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        //Consultas
        try {
            //Ejecuta el query
            ResultSet query = conexion.createStatement().executeQuery("SELECT l.nombre, l.Primer_Apellido FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider WHERE p.Constructora = 'Pegaso'");
            //Recorre los resultados del query
            while (query.next()) {
                //Almacena los resultados del query en un objeto Proyecto
                Lider objLider = new Lider(query.getString("Nombre"),query.getString("Primer_Apellido"));
                // Agrega el objeto al arraylist
                lideres.add(objLider);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return lideres;
    }// Fin del método query_requerimiento_4

}