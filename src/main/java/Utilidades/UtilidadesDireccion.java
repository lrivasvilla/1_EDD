package Utilidades;

import modelos.Provincia;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UtilidadesDireccion {
    public static boolean esCPValido(String cp){

        try{
            String dosPrimeros = cp.substring(0, 2);
            int codPos = Integer.parseInt(cp);

            if(cp.length()==5 && codPos>=1001 && codPos<=52999){
                return true;
            }

        }catch(Exception e){
            return false;
        }

        return false;
    }

    public static boolean esProvinciaValida(Provincia p){
        for(Provincia prov: mapaProvincias().values()){
            if (prov.getCodigo().equals(p.getCodigo()) && prov.getNombre().equals(p.getNombre())) {
                return true;
            }
        }
    return false;
    }

    public static Map<String, Provincia> mapaProvincias(){
        Map<String, Provincia> provincias = new HashMap<>();

        provincias.put("Álava", new Provincia("Álava", "01"));
        provincias.put("Albacete", new Provincia("Albacete", "02"));
        provincias.put("Alicante", new Provincia("Alicante", "03"));
        provincias.put("Almería", new Provincia("Almería", "04"));
        provincias.put("Ávila", new Provincia("Ávila", "05"));
        provincias.put("Badajoz", new Provincia("Badajoz", "06"));
        provincias.put("Islas Baleares", new Provincia("Islas Baleares", "07"));
        provincias.put("Barcelona", new Provincia("Barcelona", "08"));
        provincias.put("Burgos", new Provincia("Burgos", "09"));
        provincias.put("Cáceres", new Provincia("Cáceres", "10"));
        provincias.put("Cádiz", new Provincia("Cádiz", "11"));
        provincias.put("Castellón", new Provincia("Castellón", "12"));
        provincias.put("Ciudad Real", new Provincia("Ciudad Real", "13"));
        provincias.put("Córdoba", new Provincia("Córdoba", "14"));
        provincias.put("A Coruña", new Provincia("A Coruña", "15"));
        provincias.put("Cuenca", new Provincia("Cuenca", "16"));
        provincias.put("Girona", new Provincia("Girona", "17"));
        provincias.put("Granada", new Provincia("Granada", "18"));
        provincias.put("Guadalajara", new Provincia("Guadalajara", "19"));
        provincias.put("Guipúzcoa", new Provincia("Guipúzcoa", "20"));
        provincias.put("Huelva", new Provincia("Huelva", "21"));
        provincias.put("Huesca", new Provincia("Huesca", "22"));
        provincias.put("Jaén", new Provincia("Jaén", "23"));
        provincias.put("León", new Provincia("León", "24"));
        provincias.put("Lleida", new Provincia("Lleida", "25"));
        provincias.put("La Rioja", new Provincia("La Rioja", "26"));
        provincias.put("Lugo", new Provincia("Lugo", "27"));
        provincias.put("Madrid", new Provincia("Madrid", "28"));
        provincias.put("Málaga", new Provincia("Málaga", "29"));
        provincias.put("Murcia", new Provincia("Murcia", "30"));
        provincias.put("Navarra", new Provincia("Navarra", "31"));
        provincias.put("Ourense", new Provincia("Ourense", "32"));
        provincias.put("Asturias", new Provincia("Asturias", "33"));
        provincias.put("Palencia", new Provincia("Palencia", "34"));
        provincias.put("Las Palmas", new Provincia("Las Palmas", "35"));
        provincias.put("Pontevedra", new Provincia("Pontevedra", "36"));
        provincias.put("Salamanca", new Provincia("Salamanca", "37"));
        provincias.put("Santa Cruz de Tenerife", new Provincia("Santa Cruz de Tenerife", "38"));
        provincias.put("Cantabria", new Provincia("Cantabria", "39"));
        provincias.put("Segovia", new Provincia("Segovia", "40"));
        provincias.put("Sevilla", new Provincia("Sevilla", "41"));
        provincias.put("Soria", new Provincia("Soria", "42"));
        provincias.put("Tarragona", new Provincia("Tarragona", "43"));
        provincias.put("Teruel", new Provincia("Teruel", "44"));
        provincias.put("Toledo", new Provincia("Toledo", "45"));
        provincias.put("Valencia", new Provincia("Valencia", "46"));
        provincias.put("Valladolid", new Provincia("Valladolid", "47"));
        provincias.put("Vizcaya", new Provincia("Vizcaya", "48"));
        provincias.put("Zamora", new Provincia("Zamora", "49"));
        provincias.put("Zaragoza", new Provincia("Zaragoza", "50"));
        provincias.put("Ceuta", new Provincia("Ceuta", "51"));
        provincias.put("Melilla", new Provincia("Melilla", "52"));

        return provincias;
    }
}
