import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;
import modelos.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class pruebaV2 {
    public static void main(String[] args) {

        //Fecha
        LocalDate fecha1 = LocalDate.of(1995, 1, 1);
        LocalDate fecha2 = LocalDate.of(2016, 12, 31);
        LocalDate fecha3 = LocalDate.of(2018, 12, 31);
        LocalDate fecha4 = LocalDate.of(2025, 12, 31);
        LocalDate fecha5 = LocalDate.of(2001, 12, 31);

        //Dirección
        Direccion direccion1 = new Direccion(TipoVia.CALLE,"Juan de la Encina", 12, "PBJ","41003","Sevilla","Sevilla");
        Direccion direccion2 = new Direccion(TipoVia.CALLE,"Feria", 12, "1º 'A'","41002","Sevilla","Sevilla");

        //Persona
        Persona persona1 = new Persona("Guillermo","Tejado","Sánchez","70406755Y",fecha1,direccion1, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
        Persona persona2 = new Persona("Luis","Rivas","Villa","20061394N",fecha4,direccion2,Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977");

        //Conductor
        Conductor conductor1 = new Conductor("Guillermo","Tejado","Sánchez","70406755Y",fecha1,direccion1,Sexo.MASCULINO,"España","dsdsd@gmail.com","654879654",fecha3,12,8);

        //Vehiculo
        Vehiculo vehiculo1 = new Vehiculo("Ford","Focus","4366KCJ",fecha3,"Azul marino",persona2);
        Vehiculo vehiculo2 = new Vehiculo("Audi","A4","9497GCG",fecha3,"Azul marino",persona1);
        Vehiculo vehiculo3 = new Vehiculo("BMW","Z4","2864HDB",fecha1,"Azul marino",persona2);

        List<Vehiculo> listaVehiculos = Arrays.asList(vehiculo1,vehiculo2,vehiculo3);

        //Coche
        Coche coche1 = new Coche("Ford","Focus","4366KCJ",fecha5,"Azul marino",persona2,5,TipoCombustible.DIESEL,Traccion.TRASERA,false);

        //Moto
        Moto moto1 = new Moto("Kawasaki","Z900","2864HDB",fecha3,"Negro",persona1,49,false);

        //Aseguradora
        Aseguradora aseg = new Aseguradora("Aseguradora Aseg",direccion1,"654123587",listaVehiculos);


        System.out.println("\n✅Verificar DNI/NIE (indicándolo):");

        if(UtilidadesPersona.esNIFValido("20061394N")){
            System.out.println("DNI/NIE válido");
            }
            System.out.println("DNI/NIE inválido");


        System.out.println("\n✅Verificar DNI/NIE (Persona):");
        try{
            Persona personax = new Persona("Guillermo","Tejado","Sánchez","70406755",fecha1,direccion1, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
            if(UtilidadesPersona.esNIFValido(personax)){
                System.out.println("DNI/NIE válido");
            }
        } catch (IllegalArgumentException e){
            System.out.println("DNI/NIE NO válido");
        }


        System.out.println("\n✅Calcular edad de una persona (Persona):");
        System.out.println(UtilidadesPersona.getEdad(persona1)+" años");

        System.out.println("\n✅Calcular si una persona es mayor de edad (Persona):");
        if (UtilidadesPersona.esMayorEdad(persona2)) {
            System.out.println("Persona mayor de edad");
        }else{
            System.out.println("Persona menor de edad");
        }

        System.out.println("\n✅Calcular si una persona es menor a 25 (Persona):");
        if (UtilidadesPersona.esMenor25(persona1)) {
            System.out.println("Persona menor de 25");
        }else{
            System.out.println("Persona mayor de 25");
        }

        System.out.println("\n✅Calcular si una matrícula es válida (matricula):");
        if (UtilidadesVehiculo.esMatriculaValida(vehiculo2.getMatricula())) {
            System.out.println("La matricula es válida");
        }else{
            System.out.println("La matrícula es invalida");
        }

        System.out.println("\n✅Calcular edad vehículo (Vehículo):");
        System.out.println(UtilidadesVehiculo.calculaEdad(vehiculo1)+" años");

        System.out.println("\n✅Calcular si la fecha de matriculación es válida (LocalDate):");
        if(UtilidadesVehiculo.validaFechaMatriculacion(fecha5)){
            System.out.println("La fecha de matriculación es valida");
        }else{
            System.out.println("La fecha de matriculación es invalida");
        }

        System.out.println("\n✅Recibir lista de coches indicando la persona que es dueña:\n");
        System.out.println(UtilidadesVehiculo.getVehiculos(listaVehiculos,persona2));

        System.out.println("\n\uD83D\uDEE1️\uD83D\uDEE1️\uD83D\uDEE1️ Aseguradora \uD83D\uDEE1️\uD83D\uDEE1️\uD83D\uDEE1️\n");
        System.out.println(aseg);
    }
}
