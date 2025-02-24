package modelos;
import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;

import java.security.PrivilegedActionException;
import java.util.Objects;
import java.time.LocalDate;

public class Persona {
    //Atributos
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    private Sexo sexo;
    private String paisOrigen;
    private String email;
    private String telefono;

    //Constructor1
    public Persona(String nombre, String apellido1, String apellido2, String nif, LocalDate fechaNacimiento, Direccion direccion, Sexo sexo, String paisOrigen, String email, String telefono) {
        this.id= contador;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        if(UtilidadesPersona.esNIFValido(nif)){
            this.nif = nif;
        }else{
            throw new IllegalArgumentException("El DNI/NIE debe ser válido");
        }
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.sexo = sexo;
        this.paisOrigen = paisOrigen;
        this.email = email;
        this.telefono = telefono;
        contador ++;
    }

    //Constructor copia
    public Persona(Persona persona) {
        this.id = persona.id;
        this.nombre = persona.nombre;
        this.apellido1 = persona.apellido1;
        this.apellido2 = persona.apellido2;
        this.nif = persona.nif;
        this.fechaNacimiento = persona.fechaNacimiento;
        this.direccion = persona.direccion;
        this.sexo = persona.sexo;
        this.paisOrigen = persona.paisOrigen;
        this.email = persona.email;
        this.telefono = persona.telefono;
    }

    //Constructor vacio
    public Persona() {
        this.id = 0;
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.nif = "";
        this.fechaNacimiento = null;
        this.direccion = null;
        this.sexo = null;
        this.paisOrigen = "";
        this.email = "";
        this.telefono = "";
    }

    //Getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public String getPaisOrigen() {
        return paisOrigen;
    }
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //OtrosMetodos
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nif, persona.nif) && Objects.equals(fechaNacimiento, persona.fechaNacimiento) && Objects.equals(telefono, persona.telefono);
    }

    public int hashCode() {
        return Objects.hash(id, nif, fechaNacimiento, telefono);
    }

    private static int contador = 1;

    //ToString
    public String toString() {
        return  "\n\tNombre: "+getNombre()+" "+getApellido1()+" "+getApellido2()+
                "\n\tNIF: "+getNif()+
                "\n\tFecha de nacimiento: "+getFechaNacimiento()+
                "\n\tDirección: " +getDireccion()+
                "\n\tSexo: "+getSexo()+
                "\n\tPaís de origen: "+getPaisOrigen()+
                "\n\tEmail: "+getEmail()+
                "\n\tTeléfono: "+getTelefono()+"\n";
    }
}
