package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Poliza {
    //Atributos
    private int id; //
    private String numero;
    private List<AnualidadPoliza> anualidades; //
    private AnualidadPoliza.EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion ultimaCotizacionBase;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;

    //Constructor
    public Poliza (List<AnualidadPoliza> anualidades) {
        this.id = contador;
        this.anualidades = anualidades;
        this.numero = anualidades.getLast().getNumero();
        this.estadoPoliza = anualidades.getLast().getEstadoPoliza();
        this.motivoAnulacion = anualidades.getLast().getMotivoAnulacion();
        this.ultimaCotizacionBase = anualidades.getLast().getCotizacionBase();
        this.tomador = anualidades.getLast().getTomador();
        this.conductorPrincipal = anualidades.getLast().getConductorPrincipal();
        this.conductoresOcasionales = anualidades.getLast().getConductoresOcasionales();
        this.precioModalidad = anualidades.getLast().getPrecioModalidad();
        this.precioFinal = anualidades.getLast().getPrecioFinal();
        this.fechaInicioAnualidad = anualidades.getLast().getFechaInicioAnualidad();
        this.fechaFinAnualidad = anualidades.getLast().getFechaFinAnualidad();
        this.fechaAnulacion = anualidades.getLast().getFechaAnulacion();
        contador ++;
    }

    //Constructor copia
    public Poliza (Poliza poliza){
        this.id = poliza.id;
        this.numero = poliza.numero;
        this.anualidades = poliza.anualidades;
        this.estadoPoliza = poliza.estadoPoliza;
        this.motivoAnulacion = poliza.motivoAnulacion;
        this.ultimaCotizacionBase = poliza.ultimaCotizacionBase;
        this.tomador = poliza.tomador;
        this.conductorPrincipal = poliza.conductorPrincipal;
        this.conductoresOcasionales = poliza.conductoresOcasionales;
        this.precioModalidad = poliza.precioModalidad;
        this.precioFinal = poliza.precioFinal;
        this.fechaInicioAnualidad = poliza.fechaInicioAnualidad;
        this.fechaFinAnualidad = poliza.fechaFinAnualidad;
        this.fechaAnulacion = poliza.fechaAnulacion;
    }

    //Constructor vacío
    public Poliza (){
        this.id = 0;
        this.numero = "";
        this.anualidades = new ArrayList<AnualidadPoliza>();
        this.estadoPoliza = null;
        this.motivoAnulacion = "";
        this.ultimaCotizacionBase = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = new ArrayList<Conductor>();
        this.precioModalidad = 0;
        this.precioFinal = 0;
        this.fechaInicioAnualidad = null;
        this.fechaFinAnualidad = null;
        this.fechaAnulacion = null;
    }

    //Getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public List<AnualidadPoliza> getAnualidades() {
        return anualidades;
    }
    public void setAnualidades(List<AnualidadPoliza> anualidades) {
        this.anualidades = anualidades;
    }
    public AnualidadPoliza.EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }
    public void setEstadoPoliza(AnualidadPoliza.EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }
    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }
    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }
    public Cotizacion getUltimaCotizacionBase() {
        return ultimaCotizacionBase;
    }
    public void setUltimaCotizacionBase(){
        this.ultimaCotizacionBase = null;
    }
    public Persona getTomador() {
        return tomador;
    }
    public void setTomador(Persona tomador) {
        this.tomador = tomador;
    }
    public Conductor getConductorPrincipal() {
        return conductorPrincipal;
    }
    public void setConductorPrincipal(Conductor conductorPrincipal) {
        this.conductorPrincipal = conductorPrincipal;
    }
    public List<Conductor> getConductoresOcasionales() {
        return conductoresOcasionales;
    }
    public void setConductoresOcasionales(List<Conductor> conductoresOcasionales) {this.conductoresOcasionales = conductoresOcasionales;}
    public double getPrecioModalidad() {
        return precioModalidad;
    }
    public void setPrecioModalidad(double precioModalidad) {
        this.precioModalidad = precioModalidad;
    }
    public double getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
    public LocalDate getFechaInicioAnualidad() {
        return fechaInicioAnualidad;
    }
    public void setFechaInicioAnualidad(LocalDate fechaInicioAnualidad) {this.fechaInicioAnualidad = fechaInicioAnualidad;}
    public LocalDate getFechaFinAnualidad() {
        return fechaFinAnualidad;
    }
    public void setFechaFinAnualidad(LocalDate fechaFinAnualidad) {
        this.fechaFinAnualidad = fechaFinAnualidad;
    }
    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }
    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    //HasCode y Equals
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return id == poliza.id && Objects.equals(numero, poliza.numero) && Objects.equals(tomador, poliza.tomador) && Objects.equals(fechaInicioAnualidad, poliza.fechaInicioAnualidad);
    }

    public int hashCode() {
        return Objects.hash(id, numero, tomador, fechaInicioAnualidad);
    }

    private static int contador = 1;

    //ToString
    public String toString(){
        List<String> listAux = new ArrayList<>();
        for (Conductor c: conductoresOcasionales) {
            listAux.add(c.getNombre()+" "+c.getApellido1()+" "+c.getApellido2()+" "+c.getNif());
        }

        return  "\nNúmero: "+getNumero()+
                "\nAnualidades: "+getAnualidades().getLast().getNumero()+
                "\nEstado: "+getEstadoPoliza()+
                "\nMotivo de anulación: "+getMotivoAnulacion()+
                "\nÚltima base de cotización: ▼"+"\n"+
                "\n\t"+"Cotización: "+getUltimaCotizacionBase().getModalidadElegida()+" - "+getPrecioModalidad()+" €"+
                "\n\t"+"Vehículo: "+getUltimaCotizacionBase().getVehiculo().getMarca()+" "+getUltimaCotizacionBase().getVehiculo().getModelo()+", Color: "+getUltimaCotizacionBase().getVehiculo().getColor()+" - "+getUltimaCotizacionBase().getVehiculo().getMatricula()+
                "\n\t"+"Fecha de matriculación: "+getUltimaCotizacionBase().getVehiculo().getFechaMatriculacion()+
                "\n\t"+"Dueño: "+getUltimaCotizacionBase().getVehiculo().getDuenyoActual().getNombre()+" "+getUltimaCotizacionBase().getVehiculo().getDuenyoActual().getApellido1()+" "+getUltimaCotizacionBase().getVehiculo().getDuenyoActual().getApellido2()+ " - " +getUltimaCotizacionBase().getVehiculo().getDuenyoActual().getNif()+
                "\n\t"+"Siniestros en los últimos 5 años: "+getUltimaCotizacionBase().getNumSin5()+
                "\n\t"+"¿Aparcamiento privado?: "+getUltimaCotizacionBase().isTieneAparcamientoPrivado()+"\n"+
                "\nTomador: ▼"+
                "\n\t"+getTomador()+"\n"+
                "\nConductor principal: ▼"+
                "\n\t"+getConductorPrincipal()+"\n"+
                "\nConductores ocasionales: ▼"+
                "\n\t"+getConductoresOcasionales()+"\n"+
                "\nPrecio modalidad: "+getPrecioModalidad()+" €"+
                "\nPrecio final: "+getPrecioFinal()+" €"+
                "\nFecha de inicio de la anualidad: "+getFechaInicioAnualidad()+
                "\nFecha final de la anualidad: "+getFechaFinAnualidad()+
                "\nFecha de anulación: "+getFechaAnulacion();
    }
}
