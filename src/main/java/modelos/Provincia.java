package modelos;

import Utilidades.UtilidadesDireccion;

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
    public boolean equals(Provincia p) {
        if(this == p || p == null){
            return false;
        }
        if(getCodigo().equals(p.getCodigo()) && getNombre().equals(p.getNombre())){
            return true;
        }
        return false;
    }


    public int hashCode(Provincia provincia) {
        return provincia.hashCode();
    }

    //ToString
    public String toString() {
        return nombre + ", " + codigo;
    }
}
