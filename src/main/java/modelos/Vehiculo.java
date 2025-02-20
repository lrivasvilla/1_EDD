package modelos;

import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;
import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;

import java.time.LocalDate;
import java.util.Objects;

public class Vehiculo {
    //Atributos
    private int id;
    private Marca marca;
    private Modelo modelo;
    private String matricula;
    private LocalDate fechaMatriculacion;
    private String color;
    private Persona duenyoActual;

    //Constructor marca/modelo
    public Vehiculo(int id, String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        this.id = id;
        SoporteVehiculos sop = SoporteVehiculos.getInstance();
        if (sop.esMarcaValida(marca)) {
            this.marca = sop.getMarcaByName(marca);
        } else {
            throw new IllegalArgumentException("La marca no es válida");
        }
        if (sop.esModeloValido(marca,modelo)){
            this.modelo = this.marca.getModelo(modelo);
        }else{
            throw new IllegalArgumentException("El modelo no es válido");
        }
        if(UtilidadesVehiculo.esMatriculaValida(this.matricula)){
            this.matricula = matricula;
        }else{
            throw new IllegalArgumentException("La matrícula no es válida");
        }
        if(fechaMatriculacion.isBefore(LocalDate.now())){
            this.fechaMatriculacion = fechaMatriculacion;
        }else{
            throw new IllegalArgumentException("La fecha de matriculación no puede ser posterior al día de hoy");
        }
        this.color = color;
        this.duenyoActual = duenyoActual;
    }

    //Constructor
    public Vehiculo(int id, Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.color = color;
        this.duenyoActual = duenyoActual;
    }

    //Constructor copia
    public Vehiculo(Vehiculo vehiculo) {
        this.id = vehiculo.getId();
        SoporteVehiculos sop = SoporteVehiculos.getInstance();
        this.marca = sop.getMarcaByName(vehiculo.getMarca().getNombre());
        this.modelo = vehiculo.getModelo();
        this.matricula = vehiculo.getMatricula();
        this.color = vehiculo.getColor();
        this.duenyoActual = vehiculo.getDuenyoActual();
    }

    //Constructor vacío
    public Vehiculo(){
        this.id = 0;
        this.marca = null;
        this.modelo = null;
        this.matricula = "";
        this.fechaMatriculacion = null;
        this.color = "";
        this.duenyoActual = null;
    }

    //Getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Persona getDuenyoActual() {
        return duenyoActual;
    }
    public void setDuenyoActual(Persona duenyoActual) {
        this.duenyoActual = duenyoActual;
    }

    //OtrosMetodos
    public boolean equals(Vehiculo vehiculo) {
        if(this.getId() == vehiculo.getId() && this.getMatricula().equalsIgnoreCase(vehiculo.getMatricula()) && this.getFechaMatriculacion().isEqual(vehiculo.getFechaMatriculacion())){
            return true;
        }
        return false;
    }

    public int hashCode(Vehiculo vehiculo) {
        return vehiculo.hashCode();
    }

    //ToString
    public String toString() {
        return "\n"+"\n Id: "+getId()+"\n Marca: "+getMarca()+"\n Modelo: "+getModelo()+"\n Matrícula: "
                +getMatricula()+"\n Fecha de matriculación: "+getFechaMatriculacion()+"\n Color: "+getColor()+
                "\n Dueño actual: ▼"+getDuenyoActual();
    }
}
