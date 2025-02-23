package modelos;

import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;

import java.time.LocalDate;

public class Moto extends Vehiculo {
    //Atributos
    private int cilindradaCC;
    private boolean tieneSidecar;

    //Constructor Modelo y Marca
    public Moto(Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int cilindradaCC, boolean tieneSidecar) {
        super(marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.cilindradaCC = cilindradaCC;
        this.tieneSidecar = tieneSidecar;
    }

    //Constructor
    public Moto(String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual, int cilindradaCC, boolean tieneSidecar) {
        super(marca, modelo, matricula, fechaMatriculacion, color, duenyoActual);
        this.cilindradaCC = cilindradaCC;
        this.tieneSidecar = tieneSidecar;
    }

    //Constructor copia
    public Moto(Moto moto) {
        super(moto);
        this.cilindradaCC = moto.cilindradaCC;
        this.tieneSidecar = moto.tieneSidecar;

    }

    //Constructor vacío
    public Moto() {
        super();
        this.cilindradaCC = 49;
        this.tieneSidecar = false;
    }

    //Getter y setter
    public int getCilindradaCC() {
        return cilindradaCC;
    }
    public void setCilindradaCC(int cilindradaCC) {
        this.cilindradaCC = cilindradaCC;
    }
    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
    public void setTieneSidecar(boolean tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    // equals y hashCode
    public boolean equals(Moto moto) {
        if (this.getId() == moto.getId() && this.getMatricula().equalsIgnoreCase(moto.getMatricula()) && this.cilindradaCC == moto.getCilindradaCC()) {
            return true;
        }
        return false;
    }

    //ToString
    public String toString() {

        return super.toString() +
                "\nCilindrada: " + getCilindradaCC() + " cc"+
                "\n¿Tiene sidecar?: " + isTieneSidecar();
    }
}
