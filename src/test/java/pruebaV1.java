import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;
import modelos.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class pruebaV1 {
    public static void main(String[] args) {

        //Fecha
        LocalDate fecha1 = LocalDate.of(1995, 1, 1);
        LocalDate fecha2 = LocalDate.of(2016, 12, 31);
        LocalDate fecha3 = LocalDate.of(2018, 12, 31);
        LocalDate fecha4 = LocalDate.of(2024, 12, 31);
        LocalDate fecha5 = LocalDate.of(2001, 12, 31);

        //Dirección
        Direccion direccion1 = new Direccion(TipoVia.CALLE,"Juan de la Encina", 12, "PBJ","41003","Sevilla","Sevilla");
        Direccion direccion2 = new Direccion(TipoVia.CALLE,"Feria", 12, "1º 'A'","41002","Sevilla","Sevilla");

        //Persona
        Persona persona1 = new Persona("Guillermo","Tejado","Sánchez","20061394N",fecha1,direccion1,Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
        Persona persona2 = new Persona("Luis","Rivas","Villa","45021931Y",fecha1,direccion2,Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977");

        //Conductor
        Conductor conductor1 = new Conductor("Guillermo","Tejado","Sánchez","45021931Y",fecha1,direccion1,Sexo.MASCULINO,"España","juasjuas@gfne.com","652147896",fecha3,12,8);

        //Vehiculo
        Vehiculo vehiculo1 = new Vehiculo("Ford","Focus","2673DGC",fecha3,"Azul marino",persona2);
        Vehiculo vehiculo2 = new Vehiculo("Audi","A4","2433JJL",fecha4,"Azul marino",persona1);
        Vehiculo vehiculo3 = new Vehiculo("BMW","Z4","0664DHF",fecha1,"Azul marino",persona2);

        List<Vehiculo> listaVehiculos = Arrays.asList(vehiculo1,vehiculo2,vehiculo3);

        //Coche
        Coche coche1 = new Coche("Audi","A4","3261LLL",fecha5,"Azul marino",persona2,5,TipoCombustible.DIESEL,Traccion.TRASERA,false);
        Coche coche2 = new Coche("Ford","Focus","3261LLL",fecha5,"Azul marino",persona2,5,TipoCombustible.DIESEL,Traccion.TRASERA,false);

        //Moto
        Moto moto1 = new Moto("Kawasaki","Ninja ZX-6R","3261LLL",fecha4,"Negro",persona1,49,false);
        Moto moto2 = new Moto("Honda","Rebel 500","4753KCD",fecha4,"Negro",persona1,49,false);

        System.out.println("\n\uD83D\uDE4B\uD83D\uDE4B\uD83D\uDE4B PERSONA \uD83D\uDE4B\uD83D\uDE4B\uD83D\uDE4B");
        System.out.println(persona1);
        System.out.println("\n⚙️⚙️⚙️ CONDUCTOR ⚙️⚙️⚙️");
        System.out.println(conductor1);
        System.out.println("\n\uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5 VEHÍCULO 🚗🚗🚗\n");
        System.out.println(vehiculo1);
        System.out.println("\n\uD83D\uDE97\uD83D\uDE97\uD83D\uDE97 COCHE \uD83D\uDE97\uD83D\uDE97\uD83D\uDE97");
        System.out.println(coche1);
        System.out.println("\n\uD83D\uDE97\uD83D\uDE97\uD83D\uDE97 COCHE \uD83D\uDE97\uD83D\uDE97");
        System.out.println(coche2);
        System.out.println("\n\uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5 MOTO \uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5");
        System.out.println(moto1);
        System.out.println("\n\uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5 MOTO \uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5");
        System.out.println(moto2);


    }
}
