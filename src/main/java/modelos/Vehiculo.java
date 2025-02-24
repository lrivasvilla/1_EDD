package modelos;
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
    public Vehiculo(String marca, String modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        this.id = contador;
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
        if(UtilidadesVehiculo.esMatriculaValida(matricula)){
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
        contador ++;
    }

    //Constructor
    public Vehiculo(Marca marca, Modelo modelo, String matricula, LocalDate fechaMatriculacion, String color, Persona duenyoActual) {
        this.id = contador;
        this.marca = marca;
        this.modelo = modelo;
        if(UtilidadesVehiculo.esMatriculaValida(matricula)){
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
        contador ++;
    }

    //Constructor copia
    public Vehiculo(Vehiculo vehiculo) {
        this.id = vehiculo.getId();
        SoporteVehiculos sop = SoporteVehiculos.getInstance();
        this.marca = sop.getMarcaByName(vehiculo.getMarca().getNombre());
        this.modelo = vehiculo.getModelo();
        this.matricula = vehiculo.getMatricula();
        this.fechaMatriculacion = vehiculo.getFechaMatriculacion();
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id && Objects.equals(matricula, vehiculo.matricula) && Objects.equals(fechaMatriculacion, vehiculo.fechaMatriculacion) && Objects.equals(duenyoActual, vehiculo.duenyoActual);
    }


    public int hashCode() {
        return Objects.hash(id, matricula, fechaMatriculacion, duenyoActual);
    }

    private static int contador = 1;

    //ToString
    public String toString() {
        return  "\nId: "+ getId()+
                "\nMarca: "+getMarca()+
                "\nModelo: "+getModelo()+
                "\nMatrícula: " +getMatricula()+
                "\nFecha de matriculación: "+getFechaMatriculacion()+
                "\nColor: "+getColor()+
                "\nDueño actual: ▼"+"\n"+getDuenyoActual()+
                "\n              ▲";
    }
}
