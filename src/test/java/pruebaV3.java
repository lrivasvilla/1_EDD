import Utilidades.UtilidadesDireccion;
import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;
import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pruebaV3 {
    public static void main(String[] args) {

        //Fecha nacimiento
        LocalDate fec1 = LocalDate.of(1995,8,14);
        LocalDate fec2 = LocalDate.of(1996,6,12);
        LocalDate fec3 = LocalDate.of(1991,3,8);
        LocalDate fec4 = LocalDate.of(2000,1,9);
        LocalDate fec5 = LocalDate.of(2006,4,30);
        LocalDate fec6 = LocalDate.of(1996,1,1);
        LocalDate fec7 = LocalDate.of(1998,1,1);
        LocalDate fec8 = LocalDate.of(1990,1,1);
        LocalDate fec9 = LocalDate.of(2005,1,1);

        //Provincia
        Provincia prov1 = new Provincia("Sevilla","41");
        Provincia prov2 = new Provincia("Madrid", "28");
        Provincia prov3 = new Provincia("Barcelona", "08");
        Provincia prov4 = new Provincia("Valencia", "46");
        Provincia prov5 = new Provincia("Málaga", "29");
        Provincia prov6 = new Provincia("Cádiz", "11");
        Provincia prov7 = new Provincia("Granada", "18");
        Provincia prov8 = new Provincia("Zaragoza", "50");

        //Direccion
        Direccion dir1 = new Direccion(TipoVia.CALLE,"Juan de la Encina",12,"PBJ","41003","Sevilla",prov1);
        Direccion dir2 = new Direccion(TipoVia.CALLE,"Iniesta",23,"1º A","41002","Sevilla",prov1);
        Direccion dir3 = new Direccion(TipoVia.AVENIDA, "Gran Vía", 10, "2º B", "28013", "Madrid", prov2);
        Direccion dir4 = new Direccion(TipoVia.CALLE, "Iniesta", 23, "1º A", "41002", "Sevilla", prov1);
        Direccion dir5 = new Direccion(TipoVia.AVENIDA, "Marítimo", 5, "Bajo D", "29016", "Málaga", prov5);
        Direccion dir6 = new Direccion(TipoVia.PLAZA, "Mayor", 7, "3º C", "46001", "Valencia", prov4);
        Direccion dir7 = new Direccion(TipoVia.CALLE, "Serrano", 45, "4º Izq", "08006", "Barcelona", prov3);
        Direccion dir8 = new Direccion(TipoVia.CALLE, "Real", 12, "Ático 1", "11002", "Cádiz", prov6);
        Direccion dir9 = new Direccion(TipoVia.CALLEJON, "Secreto", 8, "Sótano", "18002", "Granada", prov7);
        Direccion dir10 = new Direccion(TipoVia.CALLE, "San Juan", 15, "Bajo A", "50010", "Zaragoza", prov8);

        //Persona
        Persona p1 = new Persona("Luis","Rivas","Villa","20061394N",fec1,dir1, Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977");
        Persona p2 = new Persona("Guillermo","Tejado","Sánchez","X1234567L",fec2,dir2, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
        Persona p3 = new Persona("Marta", "López", "García", "89043584G", fec3, dir3, Sexo.FEMENINO, "España", "mlopez@gmail.com", "622345678");
        Persona p4 = new Persona("Carlos", "Fernández", "Ruiz", "21779316H", fec4, dir4, Sexo.MASCULINO, "España", "cfernandez@gmail.com", "699123456");
        Persona p5 = new Persona("Ana", "Martínez", "Pérez", "25006922B", fec5, dir5, Sexo.FEMENINO, "España", "amartinez@gmail.com", "611987654");
        Persona p6 = new Persona("Javier", "Sánchez", "Gómez", "79844911C", fec6, dir6, Sexo.MASCULINO, "España", "jsanchez@gmail.com", "655678123");
        Persona p7 = new Persona("Elena", "Gómez", "López", "57674882J", fec7, dir7, Sexo.FEMENINO, "España", "egomez@gmail.com", "633456789");
        Persona p8 = new Persona("Pablo", "Díaz", "Martín", "41050405M", fec1, dir8, Sexo.MASCULINO, "España", "pdiaz@gmail.com", "677112233"); // NIE válido
        Persona p9 = new Persona("Lucía", "Ruiz", "Santos", "18501653Q", fec2, dir1, Sexo.FEMENINO, "España", "lruiz@gmail.com", "644789321"); // NIE válido
        Persona p10 = new Persona("Sergio", "Navarro", "Ortega", "75257770E", fec3, dir2, Sexo.MASCULINO, "España", "snavarro@gmail.com", "688334455"); // NIE válido



        //Conductor
        Conductor c1 = new Conductor("Luis","Rivas","Villa","20061394N",fec1,dir1, Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977",fec5,12,8);
        Conductor c2 = new Conductor("Guillermo","Tejado","Sánchez","X1234567L",fec2,dir2, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952",fec1, 14,5);
        Conductor c3 = new Conductor("Marta", "López", "García", "89043584G", fec3, dir3, Sexo.FEMENINO, "España", "mlopez@gmail.com", "622345678", fec2, 12, 3);
        Conductor c4 = new Conductor("Carlos", "Fernández", "Ruiz", "21779316H", fec4, dir4, Sexo.MASCULINO, "España", "cfernandez@gmail.com", "699123456", fec3, 14, 7);
        Conductor c5 = new Conductor("Ana", "Martínez", "Pérez", "25006922B", fec5, dir5, Sexo.FEMENINO, "España", "amartinez@gmail.com", "611987654", fec4, 14, 4);
        Conductor c6 = new Conductor("Javier", "Sánchez", "Gómez", "79844911C", fec6, dir6, Sexo.MASCULINO, "España", "jsanchez@gmail.com", "655678123", fec5, 14, 6);
        Conductor c7 = new Conductor("Elena", "Gómez", "López", "57674882J", fec7, dir7, Sexo.FEMENINO, "España", "egomez@gmail.com", "633456789", fec6, 12, 2);
        Conductor c8 = new Conductor("Pablo", "Díaz", "Martín", "41050405M", fec8, dir8, Sexo.MASCULINO, "España", "pdiaz@gmail.com", "677112233", fec7, 12, 5);
        Conductor c9 = new Conductor("Lucía", "Ruiz", "Santos", "18501653Q", fec9, dir1, Sexo.FEMENINO, "España", "lruiz@gmail.com", "644789321", fec8, 14, 4);
        Conductor c10 = new Conductor("Sergio", "Navarro", "Ortega", "75257770E", fec9, dir2, Sexo.MASCULINO, "España", "snavarro@gmail.com", "688334455", fec9, 12, 8);

        List<Conductor> conductores = new ArrayList<>();
        conductores.add(c1);
        conductores.add(c2);
        conductores.add(c3);
        conductores.add(c4);
        conductores.add(c5);
        conductores.add(c6);
        conductores.add(c7);
        conductores.add(c8);
        conductores.add(c9);
        conductores.add(c10);

        // Modelos
        Modelo mod1 = new Modelo("Focus", 150.0, 200.0, 300.0);
        Modelo mod2 = new Modelo("Fiesta", 140.0, 180.0, 250.0);
        Modelo mod3 = new Modelo("Davinson", 140.0, 180.0, 250.0);
        Modelo mod4 = new Modelo("Golf", 160.0, 210.0, 320.0);
        Modelo mod5 = new Modelo("Ibiza", 145.0, 190.0, 270.0);
        Modelo mod6 = new Modelo("Astra", 155.0, 200.0, 290.0);
        Modelo mod7 = new Modelo("Megane", 150.0, 195.0, 280.0);
        Modelo mod8 = new Modelo("Civic", 165.0, 220.0, 340.0);
        Modelo mod9 = new Modelo("Corolla", 155.0, 205.0, 310.0);
        Modelo mod10 = new Modelo("Leon", 160.0, 215.0, 330.0);

        // Lista de modelos
        List<Modelo> listaModelos = new ArrayList<>();
        listaModelos.add(mod1);
        listaModelos.add(mod2);
        listaModelos.add(mod3);
        listaModelos.add(mod4);
        listaModelos.add(mod5);
        listaModelos.add(mod6);
        listaModelos.add(mod7);
        listaModelos.add(mod8);
        listaModelos.add(mod9);
        listaModelos.add(mod10);

        // Marcas
        Marca marc1 = new Marca("Ford", listaModelos);
        Marca marc2 = new Marca("Harley", listaModelos);
        Marca marc3 = new Marca("Volkswagen", listaModelos);
        Marca marc4 = new Marca("Seat", listaModelos);
        Marca marc5 = new Marca("Opel", listaModelos);
        Marca marc6 = new Marca("Renault", listaModelos);
        Marca marc7 = new Marca("Honda", listaModelos);
        Marca marc8 = new Marca("Toyota", listaModelos);
        Marca marc9 = new Marca("BMW", listaModelos);
        Marca marc10 = new Marca("Mercedes-Benz", listaModelos);



        //Vehiculo
        Vehiculo v1 = new Vehiculo(marc1,mod1,"2673DGC",fec4,"Azul oscuro",p1);
        Vehiculo v2 = new Vehiculo(marc2, mod2, "2673DGC", fec1, "Rojo", p2);
        Vehiculo v3 = new Vehiculo(marc3, mod3, "2673DGC", fec2, "Blanco", p3);
        Vehiculo v4 = new Vehiculo(marc4, mod4, "2673DGC", fec3, "Negro", p4);
        Vehiculo v5 = new Vehiculo(marc5, mod5, "2673DGC", fec5, "Gris", p5);
        Vehiculo v6 = new Vehiculo(marc6, mod6, "2673DGC", fec6, "Verde", p6);
        Vehiculo v7 = new Vehiculo(marc7, mod7, "2673DGC", fec7, "Azul", p7);
        Vehiculo v8 = new Vehiculo(marc8, mod8, "2673DGC", fec8, "Amarillo", p8);
        Vehiculo v9 = new Vehiculo(marc9, mod9, "2673DGC", fec9, "Plateado", p9);
        Vehiculo v10 = new Vehiculo(marc10, mod10, "2673DGC", fec9, "Burdeos", p10);

        //Lista de vehículos
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);
        listaVehiculos.add(v5);
        listaVehiculos.add(v6);
        listaVehiculos.add(v7);
        listaVehiculos.add(v8);
        listaVehiculos.add(v9);
        listaVehiculos.add(v10);


        //Coche
        Coche coc1 = new Coche(marc1,mod2,"2673DGC",fec4,"Azul oscuro",p1,5,TipoCombustible.DIESEL,Traccion.TRASERA,false);

        //Moto
        Moto mot1 = new Moto(marc2,mod2,"2673DGC",fec4,"Negro",p2,125,false);
        Moto mot2 = new Moto("Kawasaki","Z900","2673DGC",fec4,"Negro",p1,49,false);


//        System.out.println(SoporteVehiculos.getInstance().listaModelos("Ford"));
//        System.out.println(SoporteVehiculos.getInstance().getMarcas());
//
//        System.out.println(SoporteVehiculos.getInstance().listaMarcasMotos());
//        System.out.println(SoporteVehiculos.getInstance().listaMarcasCoches());
//
//
//        System.out.println(SoporteVehiculos.getInstance().esMarcaValida("Ford"));
//
//        System.out.println(SoporteVehiculos.getInstance().getMarcasCochesList());
//        System.out.println(SoporteVehiculos.getInstance().getMarcasMotosList());


        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("\n✅✅✅ VALIDACIÓNES ✅✅✅️");

        System.out.println("\n✅Validar NIF");
        try{
            Persona personax = new Persona("Guillermo","Tejado","Sánchez","70406j",fec1,dir1, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
            if(UtilidadesPersona.esNIFValido(personax)){
                System.out.println("DNI/NIE válido");
            }
        } catch (IllegalArgumentException e){
            System.out.println("DNI/NIE NO válido");
        }

        System.out.println("\n✅Validar persona mayor de edad");

        Persona personaMenor = new Persona("Guillermo","Tejado","Sánchez","89043584G",LocalDate.of(2020,12,2),dir1, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");
        if(UtilidadesPersona.esMayorEdad(personaMenor)){
            System.out.println("La persona es mayor de edad");
        }else {
            System.out.println("La persona es menor de edad");
        }


        System.out.println("\n✅Validar persoma mayor de 25");


        if(UtilidadesPersona.esMenor25(personaMenor)){
            System.out.println("La persona es mayor de 25");
        }else{
            System.out.println("La persona es menor de 25");}



        System.out.println("\n\uD83D\uDDFA️\uD83D\uDDFA️\uD83D\uDDFA️ PROVINCIA Y CP \uD83D\uDDFA️\uD83D\uDDFA️\uD83D\uDDFA️ ");
        System.out.println(prov1);

        System.out.println("\n\uD83D\uDDFA️Validar provincia: ");
        try{
            Provincia provErronea = new Provincia("Sevilla","43");

            if(UtilidadesDireccion.esProvinciaValida(provErronea)){
                System.out.println("La provincia es válida");
            }else{
                System.out.println("La provincia NO es válida");
            }

        } catch (Exception e){
            System.out.println("La provincia NO es válida");
        }

        System.out.println("\n\uD83D\uDDFA️Validar CP: ");
        if(UtilidadesDireccion.esCPValido("60001")){
            System.out.println("El código postal es válido");
        }else{
            System.out.println("El código postal NO es válido");
        }

        SoporteVehiculos sop = SoporteVehiculos.getInstance();

        System.out.println("\n🚗alidar Marca (String): ");
        if(sop.esMarcaValida("jamón")){
            System.out.println("La marca es válida");
        }else{
            System.out.println("la marca NO es válida");
        }

        System.out.println("\n🚗️Validar Modelo (String): ");
        if(sop.esModeloValido("jamón","smith")){
            System.out.println("El modelo es válida");
        }else{
            System.out.println("El modelo NO es válida");
        }

        System.out.println("\n🚗Validar año de matriculación: ");
        if(UtilidadesVehiculo.validaFechaMatriculacion(LocalDate.of(2026,12,2))){
            System.out.println("El año de matriculación es válido");
        }else{
            System.out.println("El año de matriculación NO es válido");
        }

        System.out.println("\n🚗Validar matricula: ");
        if(UtilidadesVehiculo.esMatriculaValida("dsad3")){
            System.out.println("La matrícula es válida");
        }else{
            System.out.println("La matrícula NO es válida");
        }

        System.out.println("\n\uD83D\uDE97\uD83D\uDE97\uD83D\uDE97 COCHE \uD83D\uDE97\uD83D\uDE97\uD83D\uDE97");
        System.out.println(coc1);
        System.out.println("\n\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD TARIFACIÓN \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\n");
        System.out.println(SoporteVehiculos.getInstance().calcularTarifa(coc1.getMarca().getNombre(),coc1.getModelo().getNombre(),coc1.getFechaMatriculacion().getYear()));

        System.out.println("\n\uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5 MOTO \uD83D\uDEF5\uD83D\uDEF5\uD83D\uDEF5");
        System.out.println(mot2);
        System.out.println("\n\uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD TARIFACIÓN \uD83D\uDCDD\uD83D\uDCDD\uD83D\uDCDD\n");
        System.out.println(SoporteVehiculos.getInstance().calcularTarifa(mot2.getMarca().getNombre(),mot2.getModelo().getNombre(),mot2.getFechaMatriculacion().getYear()));




    }
}
