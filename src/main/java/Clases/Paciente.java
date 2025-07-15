package Clases;

/**
 *
 * @author usuario
 */
public class Paciente {

    private String nombre;
    private String nombreDos;
    private String apellido;
    private long cedula;
    private long telefono;
    private int edad;
    private String eps;
    private String sintomas;
    private int prioridad;
    private boolean atendido;
    private boolean cantidadAtendidos;

    public Paciente(String nombre, String apellido, long cedula, long telefono, int edad, String eps, String sintomas, int prioridad, boolean atendido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.edad = edad;
        this.eps = eps;
        this.sintomas = sintomas;
        this.prioridad = prioridad;
        this.atendido = atendido;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

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

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    @Override
    public String toString() {
        return "Paciente " + nombre + " " + apellido + " identificado con la cedula " + cedula + " con prioridad " + prioridad + " con los sisntomas " + sintomas + " " + atendido;
    }

}
