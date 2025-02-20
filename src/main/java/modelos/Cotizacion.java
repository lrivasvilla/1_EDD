package modelos;

import Utilidades.UtilidadesCotizacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cotizacion {
    //Atributos
    private int id;
    private int codigo;
    private LocalDate fechaCotizacion;
    private LocalDate fechaInicio;
    private Vehiculo vehiculo;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private boolean tieneAparcamientoPrivado;
    private int numSin5;
    private double precioTERC;
    private double precioTAMP;
    private double precioTRIE;
    public enum modalidadElegida{PrecioTERC,PrecioTAMP,PrecioTRIE}
    private modalidadElegida modalidadElegida;

    //Constructor
    public Cotizacion(int id, int codigo,LocalDate fechaCotizacion, LocalDate fechaInicio, Vehiculo vehiculo, Persona tomador, Conductor conductorPrincipal, List<Conductor> conductoresOcasionales, boolean tieneAparcamientoPrivado, int numSin5, modalidadElegida modalidadElegida) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCotizacion = fechaCotizacion;
        this.fechaInicio = fechaInicio;
        this.vehiculo = vehiculo;
        this.tomador = tomador;
        this.conductorPrincipal = conductorPrincipal;
        this.conductoresOcasionales = conductoresOcasionales;
        this.tieneAparcamientoPrivado = tieneAparcamientoPrivado;
        if(numSin5 < 6){
            this.numSin5 = numSin5;
        }else{
            throw new IllegalArgumentException("No puedes ser asegurado, tienes más de 6 siniestros en los últimos 5 años");
        }
        UtilidadesCotizacion aux = new UtilidadesCotizacion();
        this.precioTERC = aux.calcTarifa(this).getPrecioTERC();
        this.precioTAMP = aux.calcTarifa(this).getPrecioTAMP();
        this.precioTRIE = aux.calcTarifa(this).getPrecioTRIE();
        this.modalidadElegida = modalidadElegida;
    }

    //Constructor copia
    public Cotizacion (Cotizacion c){
        this.id = c.id;
        this.codigo = c.codigo;
        this.fechaCotizacion = c.fechaCotizacion;
        this.fechaInicio = c.fechaInicio;
        this.vehiculo = c.vehiculo;
        this.tomador = c.tomador;
        this.conductorPrincipal = c.conductorPrincipal;
        this.conductoresOcasionales = c.conductoresOcasionales;
        this.tieneAparcamientoPrivado = c.tieneAparcamientoPrivado;
        this.numSin5 = c.numSin5;
        this.precioTERC = c.precioTERC;
        this.precioTAMP = c.precioTAMP;
        this.precioTRIE = c.precioTRIE;
        this.modalidadElegida = c.modalidadElegida;

    }

    //Constructor vacío
    public Cotizacion(){
        this.id = 0;
        this.codigo = 0;
        this.fechaCotizacion = null;
        this.fechaInicio = null;
        this.vehiculo = null;
        this.tomador = null;
        this.conductorPrincipal = null;
        this.conductoresOcasionales = new ArrayList<>();
        this.tieneAparcamientoPrivado = false;
        this.numSin5 = 0;
        this.precioTERC = 0;
        this.precioTAMP = 0;
        this.precioTRIE = 0;
        this.modalidadElegida = null;

    }

    //Getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public LocalDate getFechaCotizacion() {
        return fechaCotizacion;
    }
    public void setFechaCotizacion(LocalDate fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
    public void setConductoresOcasionales(List<Conductor> conductoresOcasionales) {
        this.conductoresOcasionales = conductoresOcasionales;
    }
    public boolean isTieneAparcamientoPrivado() {
        return tieneAparcamientoPrivado;
    }
    public void setTieneAparcamientoPrivado(boolean tieneAparcamientoPrivado) {
        this.tieneAparcamientoPrivado = tieneAparcamientoPrivado;
    }
    public int getNumSin5() {
        return numSin5;
    }
    public void setNumSin5(int numSin5) {
        this.numSin5 = numSin5;
    }
    public double getPrecioTERC() {
        return precioTERC;
    }
    public void setPrecioTERC(double precioTERC) {
        this.precioTERC = precioTERC;
    }
    public double getPrecioTAMP() {
        return precioTAMP;
    }
    public void setPrecioTAMP(double precioTAMP) {
        this.precioTAMP = precioTAMP;
    }
    public double getPrecioTRIE() {
        return precioTRIE;
    }
    public void setPrecioTRIE(double precioTRIE) {
        this.precioTRIE = precioTRIE;
    }
    public modalidadElegida getModalidadElegida() {
        return modalidadElegida;
    }
    public void setModalidadElegida(modalidadElegida modalidadElegida) {
        this.modalidadElegida = modalidadElegida;
    }

    //HashCode y Equals
    public int hashCode(Cotizacion cotizacion) {
        return cotizacion.hashCode();
    }

    public boolean equals(Cotizacion cotizacion) {
        if(this.id == cotizacion.id && this.codigo == cotizacion.codigo && this.vehiculo == cotizacion.vehiculo && this.tomador.equals(cotizacion.tomador)) {
            return true;
        }
        return false;
    }

    //ToString
    public String toString() {
        List<String> listAux = new ArrayList<>();
        for (Conductor c: conductoresOcasionales) {
            listAux.add(c.getNombre()+" "+c.getApellido1()+" "+c.getApellido2()+" "+c.getNif());
        }
        return  "\nCódigo: "+getCodigo()+
                "\nFecha de cotización: "+getFechaCotizacion()+
                "\nFecha de inicio: "+getFechaInicio()+
                "\nVehiculo: ▼"+
                "\n\t"+getVehiculo().getMarca()+" "+getVehiculo().getModelo()+" "+getVehiculo().getMatricula()+"\n"+
                "\nConductor principal: ▼"+
                "\n\t"+getConductorPrincipal().getNombre()+" "+getConductorPrincipal().getApellido1()+" "+getConductorPrincipal().getApellido2()+" "+getConductorPrincipal().getNif()+"\n"+
                "\nConductores ocasionales: ▼"+
                "\n\t"+listAux+"\n"+
                "\n¿Tiene aparcamiento privado?: "+isTieneAparcamientoPrivado()+
                "\nAños sin siniestro: "+getNumSin5()+
                "\nPrecio terceros: "+getPrecioTERC()+"€"+
                "\nPrecio de terceros ampliados: "+getPrecioTAMP()+"€"+
                "\nPrecio a todo riesgo: "+getPrecioTRIE()+"€"+
                "\nModalidad: "+getModalidadElegida();
    }
}
