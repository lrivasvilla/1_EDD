import Utilidades.UtilidadesDireccion;
import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pruebaV3 {
    public static void main(String[] args) {

        //Fecha nacimiento
        LocalDate fec1 = LocalDate.of(1995,8,14);
        LocalDate fec2 = LocalDate.of(1996,6,12);
        LocalDate fec3 = LocalDate.of(1991,3,8);
        LocalDate fec4 = LocalDate.of(2000,1,9);
        LocalDate fec5 = LocalDate.of(2016,4,30);

        //Provincia
        Provincia prov1 = new Provincia("Sevilla","41");

        //Direccion
        Direccion dir1 = new Direccion(TipoVia.CALLE,"Juan de la Encina",12,"PBJ","41003","Sevilla",prov1);
        Direccion dir2 = new Direccion(TipoVia.CALLE,"Iniesta",23,"1º A","41002","Sevilla",prov1);


        //Persona
        Persona p1 = new Persona("Luis","Rivas","Villa","20061394N",fec1,dir1, Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977");
        Persona p2 = new Persona("Guillermo","Tejado","Sánchez","X1234567L",fec2,dir2, Sexo.MASCULINO,"España","gtejado@gmail.com","651478952");

        //Conductor
        Conductor c1 = new Conductor("Luis","Rivas","Villa","20061394N",fec1,dir1, Sexo.MASCULINO,"España","lrivasvilla@gmail.com","640580977",fec5,12,8);

        //Modelo
        Modelo mod1 = new Modelo("Focus",150.0,200.0,300.0);
        Modelo mod2 = new Modelo("Fiesta",140.0,180.0,250.0);
        Modelo mod3 = new Modelo("Davinson",140.0,180.0,250.0);

        List<Modelo> listaModelos = new ArrayList<>();
        listaModelos.add(mod1);
        listaModelos.add(mod2);
        listaModelos.add(mod3);

        //Marca
        Marca marc1 = new Marca("Ford",listaModelos);
        Marca marc2 = new Marca("Harley",listaModelos);

        //Vehiculo
        Vehiculo v1 = new Vehiculo(marc1,mod1,"2673DGC",fec4,"Azul oscuro",p1);

        //Coche
        Coche coc1 = new Coche(marc1,mod2,"2673DGC",fec4,"Azul oscuro",p1,5,TipoCombustible.DIESEL,Traccion.TRASERA,false);

        //Moto
        Moto mot1 = new Moto(marc2,mod2,"1234ABC",fec4,"Negro",p2,125,false);

        System.out.println(p1);
        System.out.println(c1);
        System.out.println(mod1);
        System.out.println(marc1);
        System.out.println(v1);
        System.out.println(coc1);
        System.out.println(mot1);


        System.out.println(SoporteVehiculos.getInstance().calcularTarifa("Ford","Focus",2001));

        System.out.println("/////////////////////////////////////////////////////");

    }
}
