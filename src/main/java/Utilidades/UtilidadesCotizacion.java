package Utilidades;

import com.aseguradora.utils.SoporteVehiculos;
import com.aseguradora.utils.Tarifa;
import modelos.Conductor;
import modelos.Cotizacion;

public class UtilidadesCotizacion {

    public Tarifa calcTarifa(Cotizacion cot) {

        SoporteVehiculos sop = SoporteVehiculos.getInstance();

        String marca = cot.getVehiculo().getMarca().getNombre();
        String modelo = cot.getVehiculo().getModelo().getNombre();
        int anyo = UtilidadesVehiculo.calculaEdad(cot.getVehiculo());
        String cp = cot.getConductorPrincipal().getDireccion().getCodigoPostal();

        double multiplicadorCP = sop.multiplicadorCP(cp);

        double multiplicadorParking = 1.0;
        if (cot.isTieneAparcamientoPrivado()) {
            multiplicadorParking = 0.95;
        }else{
            multiplicadorParking = 1.05;
        }

        double multiplicadorMenor25 = 1.0;
        for(Conductor cond : cot.getConductoresOcasionales()){
            if(UtilidadesPersona.esMenor25(cond)){
                multiplicadorMenor25 *= 1.05;
            }
        }
        if (UtilidadesPersona.esMenor25(cot.getConductorPrincipal())) {
            multiplicadorMenor25 *= 1.05;
        }

        double multiplicadorSin5 = 1.0;
        if(cot.getNumSin5() > 5){
            multiplicadorSin5 *= 2;
        }if(cot.getNumSin5() > 4){
            multiplicadorSin5 *= 1.07;
        }if(cot.getNumSin5() >= 3){
            multiplicadorSin5 *= 1.05;
        }if(cot.getNumSin5() > 1){
            multiplicadorSin5 *= 1.01;
        }


        Tarifa tarifaFinal = sop.calcularTarifa(marca, modelo, anyo);

        double terc = tarifaFinal.getPrecioTERC() * multiplicadorCP * multiplicadorParking * multiplicadorMenor25 * multiplicadorSin5;
        double tamp = tarifaFinal.getPrecioTAMP() * multiplicadorCP * multiplicadorParking * multiplicadorMenor25 * multiplicadorSin5;
        double trie = tarifaFinal.getPrecioTRIE() * multiplicadorCP * multiplicadorParking * multiplicadorMenor25 * multiplicadorSin5;

        tarifaFinal.setPrecioTERC((double) Math.round(terc * 100) /100);
        tarifaFinal.setPrecioTAMP((double) Math.round(tamp * 100) /100);
        tarifaFinal.setPrecioTRIE((double) Math.round(trie * 100) /100);

        return tarifaFinal;
    }
}
