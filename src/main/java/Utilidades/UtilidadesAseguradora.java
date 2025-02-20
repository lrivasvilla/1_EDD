package Utilidades;

import modelos.Aseguradora;
import modelos.Poliza;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesAseguradora {
    public Poliza recuperaPoliza(Aseguradora a, String numeroPoliza){
        for (Poliza p : a.getListaPolizas()){
            if (p.getNumero().equals(numeroPoliza)){
                return p;
            }
        }
        return null;
    }
    public List<Poliza> recuperaPolizasActivas(Aseguradora aseguradora){
        List<Poliza> polizasActivas = new ArrayList<>();

        for(Poliza poliza : aseguradora.getListaPolizas()){
            if(poliza.getEstadoPoliza().toString().equals("Vigente")){
                polizasActivas.add(poliza);
            }
        }
        return polizasActivas;
    }
    public List<Poliza> recuperaPolizasPorTomador(Aseguradora aseguradora,String nif){
        List<Poliza> polizasDni = new ArrayList<>();

        for(Poliza poli : aseguradora.getListaPolizas()){
            if(poli.getTomador().getNif().equalsIgnoreCase(nif)){
                polizasDni.add(poli);
            }
        }
        return null;
    }

    public List<Poliza> recuperaPolizasPorConductor(Aseguradora aseguradora,String nif){

    }



}
