package model.vo;

public class Lider{
    /*************
     * Atributos
     *************/
    private String nombre;
    private String apellido;

    //Constructor
    public Lider(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Consultores y Modificadores
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}