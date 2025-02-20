package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aseguradora {
    //Atributos
    private int id;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private List<Vehiculo> vehiculosAsegurados;
    private List<Poliza> listaPolizas;

    //Constructor
    public Aseguradora(int id, String nombre, Direccion direccion, String telefono, List<Vehiculo> vehiculosAsegurados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.vehiculosAsegurados = vehiculosAsegurados;
        this.listaPolizas= new ArrayList<>();
    }

    //Constructor copia
    public Aseguradora(Aseguradora aseguradora) {
        this.id = aseguradora.id;
        this.nombre = aseguradora.nombre;
        this.direccion = aseguradora.direccion;
        this.telefono = aseguradora.telefono;
        this.vehiculosAsegurados = aseguradora.vehiculosAsegurados;
    }

    //Constructor vacio
    public Aseguradora() {
        this.id = 0;
        this.nombre = "";
        this.direccion = null;
        this.telefono = "";
        this.vehiculosAsegurados = new ArrayList<>();
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
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public List<Vehiculo> getVehiculosAsegurados() {
        return vehiculosAsegurados;
    }
    public void setVehiculosAsegurados(List<Vehiculo> vehiculos) {
        this.vehiculosAsegurados = vehiculos;
    }
    public List<Poliza> getListaPolizas() {
        return listaPolizas;
    }
    public void setListaPolizas(List<Poliza> listaPolizas) {
        this.listaPolizas = listaPolizas;
    }

    //OtrosMetodos
    public boolean equals(Aseguradora aseguradora) {
        return aseguradora.id == this.id;
    }

    public int hashCode(Aseguradora aseguradora){
        return aseguradora.hashCode();
    }

    //Añadir y borrar polizas
    public List<Poliza> addPoliza(Poliza poliza){
        listaPolizas.add(poliza);
        return listaPolizas;
    }
    public List<Poliza> removePoliza(String numeroPoliza){
        for(Poliza p : listaPolizas){
            if(p.getNumero().equalsIgnoreCase(numeroPoliza)){
                listaPolizas.remove(p);
                return listaPolizas;
            }
        }
        return listaPolizas;
    }

    //ToString
    public String toString() {
        return id+", "+nombre+", "+direccion+", "+telefono+", "+vehiculosAsegurados;
    }
}
