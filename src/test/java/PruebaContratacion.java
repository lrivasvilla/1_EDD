import Utilidades.UtilidadesDireccion;
import Utilidades.UtilidadesPersona;
import Utilidades.UtilidadesVehiculo;
import com.aseguradora.utils.Marca;
import com.aseguradora.utils.Modelo;
import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PruebaContratacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Biénvenido a Aseguradora Aseg. Vamos a solicitarle sus datos para generar una póliza de su vehículo.\n");







        System.out.println("\n**** INGRESE SU DIRECCIÓN *****\n");

        TipoVia tipoVia = null;
        while (tipoVia == null) {
            System.out.println("Tipo de vía (CALLE, AVENIDA, PLAZA, PLAZOLETA o CALLEJON): ");
            try {
                tipoVia = TipoVia.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de vía inválida. Inténtelo de nuevo.");
            }
        }
        sc.nextLine();

        String nombreVia = null;
        while (nombreVia == null) {
            System.out.println("\nNombre de la vía: ");
            try{
                nombreVia = sc.nextLine().toUpperCase();
            }catch(IllegalArgumentException e){
                System.out.println("El nombre de la vía no puede estar vacío.");
            }
        }

        System.out.println("\nNúmero: ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número válido:");
            sc.next();
        }
        int numeroVia = sc.nextInt();
        sc.nextLine();

        String restoDireccion = null;
        while (restoDireccion == null) {
            System.out.println("\nDatos complementarios de la dirección: piso, planta, portal...");
            try{
                restoDireccion = sc.nextLine().toUpperCase();
            }catch(IllegalArgumentException e){
                System.out.println("El campo nu puede estar vacío.");
            }
        }

        System.out.println("\nCódigo postal: ");
        String codigoPostal = sc.next();
        while(!UtilidadesDireccion.esCPValido(codigoPostal)){
            System.out.println("\nEl código postal no es correcto, vuelva a introducirlo: ");
            codigoPostal = sc.next();
        }

        String localidad = null;
        while (localidad == null) {
            System.out.println("\nLocalidad: ");
            try{
                String respLocalidad = sc.next();
                localidad = respLocalidad.substring(0,1).toUpperCase() + respLocalidad.substring(1).toLowerCase();
            }catch(IllegalArgumentException e){
                System.out.println("El campo localidad no puede estar vacío.");
            }
        }

        System.out.println("\nProvincia: ");
        String provincia = sc.next();
        provincia = provincia.substring(0,1).toUpperCase() + provincia.substring(1).toLowerCase();

        Provincia clienteProvincia = new Provincia(provincia,codigoPostal.substring(0,2));

        while(!UtilidadesDireccion.esProvinciaValida(clienteProvincia)){
            System.out.println("\nLa provincia es incorrecta, vuelva a introducirla: ");
            provincia = sc.next();
        }
        sc.nextLine();

        Direccion clienteDireccion = new Direccion(tipoVia,nombreVia,numeroVia,restoDireccion,codigoPostal,localidad,provincia);






        System.out.println("**** INGRESE SUS DATOS PERSONALES *****\n");

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.println("\nIngrese su fecha de nacimiento (yyyy-MM-dd): ");
            try {
                fechaNacimiento = LocalDate.parse(sc.nextLine());


                if (fechaNacimiento.isAfter(LocalDate.now())) {
                    System.out.println("\nLa fecha no puede ser posterior a la actual. Inténtelo de nuevo.");
                    fechaNacimiento = null;
                }

            } catch (DateTimeParseException e) {
                System.out.println("\nIngrese una fecha en formato válido (yyyy-MM-dd).");
            }
        }

        System.out.println("\nNombre: ");
        String nombre = sc.next();

        System.out.println("\nPrimer Apellido: ");
        String apellido1 = sc.next();

        System.out.println("\nSegundo apellido: ");
        String apellido2 = sc.next();

        System.out.println("\nNIF: ");
        String nif = sc.next();
        while (!UtilidadesPersona.esNIFValido(nif)){
            System.out.println("Lo siento, NIF inválido, vuelve a introducirlo: ");
            nif = sc.next();
        }

        Sexo sexo = null;
        while(sexo == null){
            System.out.println("\nIngrese su sexo (MASCULINO, FEMENINO, NA): ");
            try{
                sexo = Sexo.valueOf(sc.next().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("El sexo debe ser como lo indicado. Inténtelo de nuevo.");
            }
        }
        sc.nextLine();

        System.out.println("\nPaís de origen: ");
        String pais = sc.next();

        String email = null;
        while(email == null){
            System.out.println("\nIngrese su email: ");
            try{
                email = sc.next();

                if (!email.matches("\\w+@\\w+\\.\\w+")){
                    System.out.println("El email debe tener un formato válido.");
                    email = null;
                }

            }catch (IllegalArgumentException e){
                System.out.println("El email debe tener un formato válido.");
            }
        }

        String telefono = null;
        while(telefono == null){
            System.out.println("\nIngrese su teléfono: ");
            try{
                telefono = sc.next();

                if(!telefono.matches("\\d{9}")){
                    System.out.println("El teléfono debe tener 9 números..");
                    telefono = null;
                }

            }catch(IllegalArgumentException e){
                System.out.println("El teléfono debe tener 9 números..");
            }
        }

        Persona clientePersona = new Persona(nombre,apellido1,apellido2,nif,fechaNacimiento,clienteDireccion,sexo,pais,email,telefono);







        System.out.println("**** INGRESE LOS DATOS DE SUS VEHÍCULOS *****\n");

        System.out.println("¿Quiere registrar un COCHE (1) o una MOTO (1)?");
        int respuesta1 = sc.nextInt();
        sc.nextLine();

        if(respuesta1 == 1){
            Marca marca = null;
            while (marca == null){
                System.out.println("\nIngrese la marca del coche: ");
                try{
                    String marcaString = sc.next().substring(0,1).toUpperCase()+sc.next().substring(1).toLowerCase();
                    SoporteVehiculos sop = SoporteVehiculos.getInstance();

                    if(sop.esMarcaValida(marcaString)){
                        marca = sop.getMarcaByName(marcaString);
                    }else{
                        System.out.println("La marca no existe");
                        marca = null;
                    }

                }catch (IllegalArgumentException e){
                    System.out.println("La marca no es válida, introduce una válida.");

                }
            }
            sc.nextLine();

            Modelo modelo = null;
            while (modelo == null){
                System.out.println("\nIngrese el modelo: ");
                try{
                    String modeloString = sc.next().substring(0,1).toUpperCase()+sc.next().substring(1).toLowerCase();
                    SoporteVehiculos sop = SoporteVehiculos.getInstance();

                    if(sop.esModeloValido(marca.toString(),modeloString)){
                        modelo = marca.getModelo(modeloString);
                    }else{
                        System.out.println("El modelo no existe");
                        modelo = null;
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("El modelo no existe");
                }
            }

            String matricula = null;
            while (matricula == null){
                System.out.println("\nIngrese la matricula: ");
                try{
                    String matriculaString = sc.next();

                    if(UtilidadesVehiculo.esMatriculaValida(matriculaString)){
                        matricula = matriculaString;
                    }else{
                        System.out.println("La matricula no existe");
                        matricula = null;
                    }
                }catch (IllegalArgumentException e){
                    System.out.println("La matricula no existe");
                }
            }



            LocalDate fechaMatriculacion = null;
            while (fechaMatriculacion == null) {
                System.out.println("\nIngrese la fecha de matriculación (yyyy-MM-dd): ");
                try {
                    fechaMatriculacion = LocalDate.parse(sc.next());


                    if (fechaMatriculacion.isAfter(LocalDate.now())) {
                        System.out.println("La fecha no puede ser posterior a la actual. Inténtelo de nuevo.");
                        fechaMatriculacion = null;
                    }

                } catch (DateTimeParseException e) {
                    System.out.println("Ingrese una fecha en formato válido (yyyy-MM-dd).");
                }
            }


            System.out.println("\nIngrese el color: ");
            String color = sc.nextLine();

            Persona duenyoActual = null;
            while (duenyoActual == null){
                System.out.println("\nEl dueño actual debe de ser el mismo que el tomador. ¿Está de acuerdo? S/N: ");
                String respuesta2 = sc.nextLine().toUpperCase();
                if (respuesta2.equals("S")){
                    duenyoActual = clientePersona;
                }else{
                    System.out.println("Es lo que hay.");
                    duenyoActual = null;
                }
            }


            int numeroPuertas = 0;
            while (numeroPuertas == 0){
                System.out.println("\nIngrese el numero de puertas: ");
                try{
                    numeroPuertas = Integer.parseInt(sc.nextLine());
                    if(numeroPuertas >5 || numeroPuertas < 2){
                        System.out.println("El numero de puertas debe estar entre 2 y 5");
                        numeroPuertas = 0;
                    }
                }catch (NumberFormatException e){
                    System.out.println("El numero de puertas no es valido.");
                }
            }



            TipoCombustible tipoCombustible = null;
            while (tipoCombustible == null){
                System.out.println("\nIngrese el tipo de combustible: (GASOLINA, DIESEL, ELECTRICO o HIBRIDO)");
                try{
                    tipoCombustible = TipoCombustible.valueOf(sc.nextLine().toUpperCase());
                }catch (IllegalArgumentException e){
                    System.out.println("El tipo de combustible no es válido");
                }
            }


            Traccion  traccion = null;
            while (traccion == null){
                System.out.println("\nIngrese el tipo de tracción: (DELANTERA, TRASERA o INTEGRAL)");
                try{
                    traccion = Traccion.valueOf(sc.nextLine().toUpperCase());
                }catch (IllegalArgumentException e){
                    System.out.println("El tipo de traccion no es válido");
                }
            }



            String rTodoTerrenoString = null;
            while (rTodoTerrenoString == null){
                System.out.println("\n¿Es Todo-Terreno?(Y/N):");
                try {
                    rTodoTerrenoString = sc.next().toUpperCase();

                    if (!rTodoTerrenoString.equals("Y") && !rTodoTerrenoString.equals("N")){
                        System.out.println("La respuesta debe ser Y/N.");
                        rTodoTerrenoString = null;
                    }

                }catch (IllegalArgumentException e){
                    System.out.println("La respuesta debe ser Y/N.");
                }

            }
            sc.nextLine();

            boolean esTodoTerreno = false;
            if(rTodoTerrenoString.equals("si")){
                esTodoTerreno = true;
            }
            if (rTodoTerrenoString.equals("no")){
                esTodoTerreno = false;
            }

            Coche clienteCoche = new Coche(marca,modelo,matricula,fechaMatriculacion,color,duenyoActual,numeroPuertas,tipoCombustible,traccion,esTodoTerreno);

            System.out.println(clienteCoche);
        }

        if(respuesta1 == 2){

        }

    }
}
