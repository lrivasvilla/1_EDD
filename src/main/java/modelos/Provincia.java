package modelos;

import Utilidades.UtilidadesDireccion;

import java.util.Objects;

public class Provincia {
    //Atributos
    private String nombre;
    private String codigo;

    //Constructor
    public Provincia(String nombre, String codigo) {
            this.nombre = nombre;
            this.codigo = codigo;
    }

    //Constructor copia
    public Provincia(Provincia provincia) {
        this.nombre = provincia.getNombre();
        this.codigo = provincia.getCodigo();
    }

    //Constructor vacío
    public Provincia() {
        this.nombre = "";
        this.codigo = "";
    }

    //Getter y setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Equals y HashCode
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(nombre, provincia.nombre) && Objects.equals(codigo, provincia.codigo);
    }

    public int hashCode() {
        return Objects.hash(nombre, codigo);
    }

    //ToString
    public String toString() {
        return nombre + ", " + codigo;
    }
}
