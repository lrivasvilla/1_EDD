package modelos;

import Utilidades.UtilidadesVehiculo;
import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;

import java.time.LocalDate;
import java.util.Objects;

public class Coche extends Vehiculo {
    //Atributos
    private int numeroPuerta;
    private TipoCombustible tipoCombustible;
    private Traccion traccion;
    private boolean esTodoTerreno;

    //Constructor Modelo y Marca
    public Coche(int id, Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int numeroPuerta, TipoCombustible tipoCombustible, Traccion traccion) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.numeroPuerta = numeroPuerta;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
    }

    //Constructor
    public Coche(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int numeroPuerta, TipoCombustible tipoCombustible, Traccion traccion) {
        super(id, marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.numeroPuerta = numeroPuerta;
        this.tipoCombustible = tipoCombustible;
        this.traccion = traccion;
    }

    //Constructor copia
    public Coche(Coche coche) {
        super(coche);
        this.numeroPuerta = coche.numeroPuerta;
        this.tipoCombustible = coche.tipoCombustible;
        this.traccion = coche.traccion;
    }

    //Constructor vacio
    public Coche(){
        super();
        this.numeroPuerta = 0;
        this.tipoCombustible = null;
        this.esTodoTerreno = false;
    }

    //Getter y setter
    public int getNumeroPuerta() {
        return numeroPuerta;
    }
    public void setNumeroPuerta(int numeroPuerta) {
        this.numeroPuerta = numeroPuerta;
    }
    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    public Traccion getTraccion() {
        return traccion;
    }
    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    // equals y hasCode
    public boolean equals(Coche coche){
        if(this.getId() == coche.getId() && this.getMatricula().equalsIgnoreCase(coche.getMatricula()) && this.getNumeroPuerta() == coche.getNumeroPuerta()){
            return true;
        }
        return false;
    }

    public int hashCode(Coche coche) {
        return super.hashCode()+coche.getNumeroPuerta();
    }

    //ToString
    public String toString() {
        return super.toString() + "\n\n Número de puertas: " + getNumeroPuerta() + "\n Tipo de combustible: " +
                getTipoCombustible() + "\n Tracción: " + getTraccion()+"\n";
    }
}
