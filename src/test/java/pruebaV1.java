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
        LocalDate fecha4 = LocalDate.of(2025, 12, 31);
        LocalDate fecha5 = LocalDate.of(2001, 12, 31);

        //Dirección
        Direccion direccion1 = new Direccion(1,TipoVia.CALLE,"Juan de la Encina", 12, "PBJ","41003","Sevilla","Sevilla");
        Direccion direccion2 = new Direccion(2,TipoVia.CALLE,"Feria", 12, "1º 'A'","41002","Sevilla","Sevilla");

        //Persona
        Persona persona1 = new Persona(1,"Guillermo","Tejado","Sánchez","20078541A",fecha1,direccion1,Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
        Persona persona2 = new Persona(2,"Luis","Rivas","Villa","20061394N",fecha1,direccion2,Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977");

        //Conductor
        Conductor conductor1 = new Conductor(1,"Guillermo","Tejado","Sánchez","20078541A",fecha1,direccion1,Sexo.MASCULINO,"España","juasjuas@gfne.com","652147896",fecha3,12,8);

        //Vehiculo
        Vehiculo vehiculo1 = new Vehiculo(1,"Ford","Focus","2673DGC",fecha3,"Azul marino",persona2);
        Vehiculo vehiculo2 = new Vehiculo(2,"Ford","Focus","5736JGC",fecha4,"Azul marino",persona1);
        Vehiculo vehiculo3 = new Vehiculo(3,"Ford","Focus","29764ASC",fecha1,"Azul marino",persona2);

        List<Vehiculo> listaVehiculos = Arrays.asList(vehiculo1,vehiculo2,vehiculo3);

        //Coche
        Coche coche1 = new Coche(1,"Ford","Focus","2673DGC",fecha5,"Azul marino",persona2,5,TipoCombustible.DIESEL,Traccion.TRASERA);

        //Moto
        Moto moto1 = new Moto(1,"Davisson´s","Harley","5249JHG",fecha4,"Negro",persona1,49,false);

        System.out.println(persona1);
        System.out.println(conductor1);
        System.out.println(vehiculo1);
        System.out.println(coche1);
        System.out.println(moto1);

    }
}
