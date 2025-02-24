package modelos;

import Utilidades.UtilidadesCotizacion;
import com.aseguradora.utils.Tarifa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnualidadPoliza {
    //Atributos
    private int id;
    private String numero;
    public enum EstadoPoliza {Vigente, Anulada, Vencida}
    private EstadoPoliza estadoPoliza;
    private String motivoAnulacion;
    private Cotizacion cotizacionBase;
    public enum ModoPago {IBAN, Tarjeta}
    private ModoPago modoPago;
    private boolean esPagoFraccionado;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private double precioModalidad;
    private double precioFinal;
    private LocalDate fechaInicioAnualidad;
    private LocalDate fechaFinAnualidad;
    private LocalDate fechaAnulacion;

    //Constructor
    public AnualidadPoliza(EstadoPoliza estadoPoliza, String motivoAnulacion,  Cotizacion cotizacionBase,
                           ModoPago modoPago, boolean esPagoFraccionado, LocalDate fechaInicioAnualidad,
                           LocalDate fechaAnulacion) {
        this.id = contador+1;
        this.estadoPoliza = estadoPoliza;
        this.motivoAnulacion = motivoAnulacion;
        this.cotizacionBase = cotizacionBase;
        this.modoPago = modoPago;
        this.esPagoFraccionado = esPagoFraccionado;
        this.tomador = new Persona(cotizacionBase.getTomador());
        this.conductorPrincipal = new Conductor(cotizacionBase.getConductorPrincipal());
        this.conductoresOcasionales = new ArrayList<Conductor>(cotizacionBase.getConductoresOcasionales());

        if(cotizacionBase.getModalidadElegida().equals(Cotizacion.modalidadElegida.PrecioTAMP))
            this.precioModalidad = new Cotizacion(cotizacionBase).getPrecioTAMP();
        else if(cotizacionBase.getModalidadElegida().equals(Cotizacion.modalidadElegida.PrecioTERC))
            this.precioModalidad = new Cotizacion(cotizacionBase).getPrecioTERC();
        else
            this.precioModalidad = new Cotizacion(cotizacionBase).getPrecioTRIE();

        Tarifa tarifaFinal = new UtilidadesCotizacion().calcTarifa(cotizacionBase);

        if(cotizacionBase.getModalidadElegida().equals(Cotizacion.modalidadElegida.PrecioTAMP)) {
            this.precioFinal = tarifaFinal.getPrecioTAMP();
        }
        if(cotizacionBase.getModalidadElegida().equals(Cotizacion.modalidadElegida.PrecioTERC)) {
            this.precioFinal = tarifaFinal.getPrecioTERC();
        }
        if(cotizacionBase.getModalidadElegida().equals(Cotizacion.modalidadElegida.PrecioTRIE)){
            this.precioFinal = tarifaFinal.getPrecioTRIE();
        }
        if(isEsPagoFraccionado()){
            this.precioFinal = (double) Math.round((this.precioFinal * 1.02) * 100) /100;
        }
        this.fechaInicioAnualidad = fechaInicioAnualidad;
        this.fechaFinAnualidad = fechaInicioAnualidad.plusYears(1);
        this.numero = calcularNumeroPoliza(fechaInicioAnualidad);
        this.fechaAnulacion = fechaAnulacion;

        contador ++;
    }

    // Constructor copia
    public AnualidadPoliza(AnualidadPoliza a){
        this.id = a.id;
        this.numero = a.numero;
        this.estadoPoliza = a.estadoPoliza;
        this.motivoAnulacion = a.motivoAnulacion;
        this.cotizacionBase = a.cotizacionBase;
        this.modoPago = a.modoPago;
        this.esPagoFraccionado = a.esPagoFraccionado;
        this.tomador = a.tomador;
        this.conductorPrincipal = a.conductorPrincipal;
        this.conductoresOcasionales = a.conductoresOcasionales;
        this.precioModalidad = a.precioModalidad;
        this.precioFinal = a.precioFinal;
        this.fechaInicioAnualidad = a.fechaInicioAnualidad;
        this.fechaFinAnualidad = a.fechaFinAnualidad;
        this.fechaAnulacion = a.fechaAnulacion;
    }

    //Constructor vacío
    public AnualidadPoliza(){
        this.id = 0;
        this.numero = "";
        this.estadoPoliza = null;
        this.motivoAnulacion = "";
        this.cotizacionBase = null;
        this.modoPago = null;
        this.esPagoFraccionado = false;
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
    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }
    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }
    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }
    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }
    public Cotizacion getCotizacionBase() {
        return cotizacionBase;
    }
    public void setCotizacionBase(Cotizacion cotizacionBase) {
        this.cotizacionBase = cotizacionBase;
    }
    public ModoPago getModoPago() {
        return modoPago;
    }
    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }
    public boolean isEsPagoFraccionado() {
        return esPagoFraccionado;
    }
    public void setEsPagoFraccionado(boolean esPagoFraccionado) {
        this.esPagoFraccionado = esPagoFraccionado;
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
    public void setFechaInicioAnualidad(LocalDate fechaInicioAnualidad) {
        this.fechaInicioAnualidad = fechaInicioAnualidad;
    }
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
        AnualidadPoliza that = (AnualidadPoliza) o;
        return id == that.id && esPagoFraccionado == that.esPagoFraccionado && Objects.equals(numero, that.numero) && Objects.equals(cotizacionBase, that.cotizacionBase) && Objects.equals(tomador, that.tomador) && Objects.equals(conductorPrincipal, that.conductorPrincipal) && Objects.equals(fechaInicioAnualidad, that.fechaInicioAnualidad);
    }

    public int hashCode() {
        return Objects.hash(id, numero, cotizacionBase, esPagoFraccionado, tomador, conductorPrincipal, fechaInicioAnualidad);
    }

    // Calcular número de poliza
    private static int contador = 0;

    public String calcularNumeroPoliza(LocalDate fechaInicioAnualidad){

        String numeroPoliza = "";

        String letrasAseg = "ASE";
        int fechaInicio = fechaInicioAnualidad.getYear();
        contador ++;

        numeroPoliza = letrasAseg+"/"+fechaInicio+"/"+contador;

        return numeroPoliza;
    }


    //ToString
    public String toString(){
        List<String> listAux = new ArrayList<>();
        for (Conductor c: conductoresOcasionales) {
            listAux.add(c.getNombre()+" "+c.getApellido1()+" "+c.getApellido2()+" "+c.getNif());
        }
        return  "\nNúmero: "+getNumero()+
                "\nEstado: "+getEstadoPoliza()+
                "\nMotivo de anulación: "+getMotivoAnulacion()+
                "\nBase de cotización: "+getCotizacionBase().getCodigo()+
                "\nModo de pago: "+getModoPago()+
                "\nPago fraccionado: "+isEsPagoFraccionado()+
                "\nTomador: ▼"+
                "\n\t"+getTomador().getNombre()+" "+getTomador().getApellido1()+" "+getTomador().getApellido2()+" "+getTomador().getNif()+"\n"+
                "\nConductor principal: ▼"+
                "\n\t"+getConductorPrincipal().getNombre()+" "+getConductorPrincipal().getApellido1()+" "+getConductorPrincipal().getApellido2()+" "+getConductorPrincipal().getNif()+"\n"+
                "\nConductores ocasionales: ▼"+
                "\n\t"+listAux+"\n"+
                "\nPrecio modalidad: "+getPrecioModalidad()+"€"+
                "\nPrecio final: "+getPrecioFinal()+"€"+
                "\nFecha de inicio de la anualidad: "+getFechaInicioAnualidad()+
                "\nFecha final de la anualidad: "+getFechaFinAnualidad()+
                "\nFecha de anulación: "+getFechaAnulacion();
    }
}
