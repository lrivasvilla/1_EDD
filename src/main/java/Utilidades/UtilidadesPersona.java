package Utilidades;

import modelos.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPersona {
    public static boolean esNIFValido(String nif){

        if(nif == null || nif.length()!=9){
            return false;
        }

        //Extrayendo numero y letra final.
        String numeroStr = "";
        char letraFinal = Character.toUpperCase(nif.charAt(8));

        // Verificar si es NIE
        if (Character.isLetter(nif.charAt(0))) {  //Si el primer caracter es letra
            char primeraLetra = Character.toUpperCase(nif.charAt(0));  //Guardamos la letra (la primera)
            if (primeraLetra != 'X' && primeraLetra != 'Y' && primeraLetra != 'Z') { // Si la letra es diferente a esas, es false
                return false;
            }

            //Generar el número a partir de NIE
            if (primeraLetra == 'X'){
                numeroStr = '0'+nif.substring(1,8);
            }
            if (primeraLetra == 'Y'){
                numeroStr = '1'+nif.substring(1,8);
            }
            if (primeraLetra == 'Z'){
                numeroStr = '2'+nif.substring(1,8);
            }

        }else if(Character.isDigit(nif.charAt(0))) { //ES UN DNI
            numeroStr = nif.substring(0,8);
        }else{
            return false;
        }

        try{
            int numero = Integer.parseInt(numeroStr);
        }catch(NumberFormatException e){
            return false;
        }

        //Calcula la letra correspondiente

        int numero = Integer.parseInt(numeroStr);
        int resto = numero % 23;
        Map<Integer, String> dicc = diccComp();

        String letraFinalBuscada = dicc.get(resto);

        if(!letraFinalBuscada.equalsIgnoreCase(String.valueOf(letraFinal))){
            return false;
        }
        return true;
    }
    public static boolean esNIFValido(Persona p){
        String nif = p.getNif();
        if(!esNIFValido(nif)){
            return false;
        };
        return true;
    }

    public static Map<Integer, String> diccComp(){
        Map<Integer, String> dicComp = new HashMap<>();
        dicComp.put(0, "T");
        dicComp.put(1, "R");
        dicComp.put(2, "W");
        dicComp.put(3, "A");
        dicComp.put(4, "G");
        dicComp.put(5, "M");
        dicComp.put(6, "Y");
        dicComp.put(7, "F");
        dicComp.put(8, "P");
        dicComp.put(9, "D");
        dicComp.put(10, "X");
        dicComp.put(11, "B");
        dicComp.put(12, "N");
        dicComp.put(13, "J");
        dicComp.put(14, "Z");
        dicComp.put(15, "S");
        dicComp.put(16, "Q");
        dicComp.put(17, "V");
        dicComp.put(18, "H");
        dicComp.put(19, "L");
        dicComp.put(20, "C");
        dicComp.put(21, "K");
        dicComp.put(22, "E");

        return dicComp;
    }

    public static int getEdad(Persona p){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = p.getFechaNacimiento();

        Period periodo = Period.between(fechaNacimiento,fechaActual);

        return periodo.getYears();
    }

    public static boolean esMayorEdad(Persona p){
        if(getEdad(p) < 18){
            return false;
        }
        return true;
    }

    public static boolean esMenor25(Persona p){
        if(getEdad(p) >= 25){
            return false;
        }
        return true;
    }
    
}
