package modelos;

import Utilidades.UtilidadesDireccion;
import com.aseguradora.utils.SoporteVehiculos;

public class Direccion {
    //Atributos
    private int id;
    private TipoVia TipoVia;
    private String nombreVia;
    private int numero;
    private String restoDireccion;
    private String codigoPostal;
    private String localidad;
    private Provincia provincia;

    //Constructor Provincia
    public Direccion(int id, TipoVia tipoVia, String nombreVia, int numero, String restoDireccion, String codigoPostal, String localidad, Provincia provincia) {
        this.id = id;
        this.TipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.restoDireccion = restoDireccion;
        if(UtilidadesDireccion.esCPValido(codigoPostal)){
            this.codigoPostal = codigoPostal;
        }else{
            throw new RuntimeException("El código postal no es valido");
        }
        this.localidad = localidad;
        if(UtilidadesDireccion.esProvinciaValida(provincia)){
            this.provincia = provincia;
        }else{
            throw new RuntimeException("La provincia no es válida");
        }

    }

    //Constructor
    public Direccion(int id, TipoVia tipoVia, String nombreVia, int numero, String restoDireccion, String codigoPostal, String localidad, String provincia) {
        this.id = id;
        this.TipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.restoDireccion = restoDireccion;
        if(UtilidadesDireccion.esCPValido(codigoPostal)){
            this.codigoPostal = codigoPostal;
        }else{
            throw new RuntimeException("El codigo de postal no es valido");
        }
        this.localidad = localidad;
        if(UtilidadesDireccion.esProvinciaValida(this.provincia)){
            this.provincia = new Provincia(provincia, UtilidadesDireccion.mapaProvincias().get(provincia).getCodigo());
        }else {
            throw new IllegalArgumentException("La provincia no es válida");
        }
    }

    //Constructor copia
    public Direccion(Direccion direccion) {
        this.id = direccion.id;
        this.TipoVia = direccion.TipoVia;
        this.nombreVia = direccion.nombreVia;
        this.numero = direccion.numero;
        this.restoDireccion = direccion.restoDireccion;
        this.codigoPostal = direccion.codigoPostal;
        this.localidad = direccion.localidad;
        this.provincia = direccion.provincia;
    }

    //Construtor vacio
    public Direccion(){
        this.id = 0;
        this.TipoVia = null;
        this.nombreVia = "";
        this.numero = 0;
        this.restoDireccion = "";
        this.codigoPostal = "";
        this.localidad = "";
        this.provincia = null;
    }

    //Getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public TipoVia getTipoVia() {
        return TipoVia;
    }
    public void setTipoVia(TipoVia TipoVia) {
        this.TipoVia = TipoVia;
    }
    public String getNombreVia() {
        return nombreVia;
    }
    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getRestoDireccion() {
        return restoDireccion;
    }
    public void setRestoDireccion(String restoDireccion) {
        this.restoDireccion = restoDireccion;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    //Equals y HasCode
    public boolean equals(Direccion direccion) {
        if(this == direccion || direccion == null){
            return false;
        }
        if(this.getId() == direccion.getId() && this.getTipoVia().equals(direccion.getTipoVia())){
            return true;
        }
        return false;
    }

    //ToString
    public String toString() {
        return getId() + ", " + getTipoVia() + ", " + getNombreVia() + ", " + getNumero() + ", " + getRestoDireccion() + ", " +
                getCodigoPostal()+ ", " + getLocalidad() + ", " + getProvincia()+".";
    }
}
