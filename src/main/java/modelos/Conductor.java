package modelos;

import Utilidades.UtilidadesPersona;

import java.time.LocalDate;
import java.util.Objects;

import static Utilidades.UtilidadesPersona.getEdad;

public class Conductor extends Persona {
    //Atributos
    private LocalDate fechaCarnet;
    private int puntosCarnet;
    private int anyosAsegurado;

    //Constructor 1
    public Conductor(String nombre, String apellido1, String apellido2, String nif, LocalDate fechaNacimiento, Direccion direccion, Sexo sexo, String paisOrigen, String email, String telefono, LocalDate fechaCarnet, int puntosCarnet, int anyosAsegurado) {
        super(nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, sexo, paisOrigen, email, telefono);
        this.fechaCarnet = fechaCarnet;
        this.puntosCarnet = puntosCarnet;
        this.anyosAsegurado = anyosAsegurado;
        if (!UtilidadesPersona.esMayorEdad(this)){
            throw new IllegalArgumentException("El conductor debe ser mayor de edad");
        }

    }

    //Constructor copia
    public Conductor(Conductor conductor){
        super(conductor);
        this.fechaCarnet = conductor.fechaCarnet;
        this.puntosCarnet = conductor.puntosCarnet;
        this.anyosAsegurado = conductor.anyosAsegurado;
    }

    //Cosntructor vacio
    public Conductor() {
        super();
        this.fechaCarnet = LocalDate.now();
        this.puntosCarnet = 12;
        this.anyosAsegurado = 0;
    }

    //Getter y setter
    public LocalDate getFechaCarnet() {
        return fechaCarnet;
    }
    public void setFechaCarnet(LocalDate fechaCarnet) {
        this.fechaCarnet = fechaCarnet;
    }
    public int getPuntosCarnet() {
        return puntosCarnet;
    }
    public void setPuntosCarnet(int puntosCarnet) {
        this.puntosCarnet = puntosCarnet;
    }
    public int getAnyosAsegurado() {
        return anyosAsegurado;
    }
    public void setAnyosAsegurado(int anyosAsegurado) {
        this.anyosAsegurado = anyosAsegurado;
    }

    //OtrosMetodos

    public boolean equals(Conductor conductor) {
        if(this.getId() == conductor.getId() && this.getNif().equalsIgnoreCase(conductor.getNif())){
            return true;
        }
        return false;

    }

    public int hashCode(Conductor conductor) {
        return conductor.hashCode();
    }

    //ToString
    public String toString() {

        return super.toString() + "\n\t\tPuntos de carnet: " + getPuntosCarnet() + "\n\t\tAños asegurado: " + getAnyosAsegurado();
    }
}
