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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaContratacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a Aseguradora Aseg. Vamos a solicitarle sus datos para generar una póliza de su vehículo.\n");
        Persona personaGeneral = null;
        Conductor conductorGeneral = null;
        List<Conductor> conductoresOcasionales = new ArrayList<Conductor>();

        int opcionConductor = 0;

        while (true) {
            System.out.println("\n*** ¿Qué datos va a introducir? ***\n\n\t👤Conductor principal(1)\n\t\uD83D\uDC65Conductor ocasional(2)\n\t✅Datos del vehículo(3)");
            try {
                opcionConductor = Integer.parseInt(sc.next().trim());

                if (opcionConductor < 1 || opcionConductor > 3) {
                    System.out.println("⚠️ Opción inválida. Por favor, ingrese 1, 2 o 3 ⚠️");
                    continue;
                }


                if (opcionConductor == 3) {
                    if (conductorGeneral == null) {
                        System.out.println("⚠️ Primero debe rellenar el formulario del conductor principal ⚠️");
                        continue;
                    } else {
                        break;
                    }
                }


                System.out.println("\n**** \uD83C\uDFE0  DIRECCIÓN \uD83C\uDFE0 *****\n");

                sc.nextLine();

                TipoVia tipoVia = null;
                while (tipoVia == null) {
                    System.out.println("\n\uD83C\uDFE0Tipo de vía (CALLE, AVENIDA, PLAZA, PLAZOLETA o CALLEJON): ");
                    try {
                        tipoVia = TipoVia.valueOf(sc.next().toUpperCase());

                    } catch (Exception e) {
                        System.out.println("⚠️ Tipo de vía inválida ⚠️");
                        sc.nextLine();
                    }
                }
                sc.nextLine();

                String nombreVia = "";
                while (nombreVia.isEmpty()) {
                    System.out.println("\n\uD83C\uDFE0 Nombre de la vía: ");
                    nombreVia = sc.nextLine().trim();
                    if (!nombreVia.isEmpty() && !nombreVia.matches("\\d+")) {
                        nombreVia = nombreVia.substring(0, 1).toUpperCase() + nombreVia.substring(1).toLowerCase();
                    } else {
                        System.out.println("⚠️ Nombre de vía inválido ⚠️");
                    }
                }

                int numeroVia = 0;
                while (numeroVia <= 0) {
                    System.out.println("\n\uD83C\uDFE0 Número: ");
                    try {
                        numeroVia = Integer.parseInt(sc.next().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Entrada inválida. Ingrese un número válido ⚠️");
                        sc.nextLine();
                    }
                }
                sc.nextLine();


                System.out.println("\n\uD83C\uDFE0 Datos complementarios de la dirección: piso, planta, portal...");
                String restoDireccion = sc.nextLine().toUpperCase();

                String codigoPostal = "";
                while (codigoPostal.isEmpty()) {
                    System.out.println("\n\uD83C\uDFE0 Código Postal: ");
                    codigoPostal = sc.next().trim();
                    if (!UtilidadesDireccion.esCPValido(codigoPostal)) {
                        System.out.println("⚠️ El código postal es incorrecto ⚠️");
                        codigoPostal = "";
                        sc.nextLine();
                    }
                }
                sc.nextLine();

                String localidad = "";
                while (localidad.isEmpty()) {
                    System.out.println("\n\uD83C\uDFE0 Localidad: ");
                    localidad = sc.nextLine().trim();
                    if (!localidad.isEmpty() && !localidad.matches("\\d+")) {
                        localidad = localidad.substring(0, 1).toUpperCase() + localidad.substring(1).toLowerCase();
                    } else {
                        System.out.println("⚠️ Entrada inválida. Ingrese localidad válida ⚠️");
                        localidad = "";
                    }
                }

                String provinciaString = "";
                while (provinciaString.isEmpty()) {
                    System.out.println("\n\uD83C\uDFE0 Provincia: ");
                    provinciaString = sc.nextLine().trim();

                    if (!provinciaString.isEmpty() || !provinciaString.matches("\\d+")) {
                        provinciaString = provinciaString.substring(0, 1).toUpperCase() + provinciaString.substring(1).toLowerCase();
                        Provincia provincia = new Provincia(provinciaString, codigoPostal.substring(0, 2));
                        if (!UtilidadesDireccion.esProvinciaValida(provincia)) {
                            System.out.println("⚠️ Entrada inválida. Ingrese provincia válida  ⚠️");
                            provinciaString = "";
                        }
                    } else {
                        System.out.println("⚠️ El campo no puede estar vacío ⚠️");
                    }
                }

                Direccion direccion = new Direccion(tipoVia, nombreVia, numeroVia, restoDireccion, codigoPostal, localidad, provinciaString);
                System.out.println("Dirección registrada con éxito.\n");


//////////////////////////////////////////////////DATOS PERSONALES////////////////////////////////////////////////////////////////////////////////////////////////


                System.out.println("\n**** 👤 DATOS PERSONALES 👤 *****\n");

                LocalDate fechaNacimiento = null;
                while (fechaNacimiento == null) {
                    System.out.println("\n👤 Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
                    try {
                        fechaNacimiento = LocalDate.parse(sc.next().trim());

                        if (fechaNacimiento.isAfter(LocalDate.now()) || Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
                            System.out.println("⚠️ La fecha no puede ser posterior a la actual y debe ser mayor de edad. Inténtelo de nuevo ⚠️");
                            fechaNacimiento = null;
                        }

                    } catch (DateTimeParseException e) {
                        System.out.println("⚠️ Ingrese una fecha en formato válido ⚠️");
                        sc.nextLine(); // Limpia el buffer
                    }
                }
                sc.nextLine(); // Limpia el buffer después de next()

                String nombre = "";
                while (nombre.isEmpty()) {
                    System.out.println("\n👤 Nombre: ");
                    nombre = sc.nextLine().trim();
                    if (!nombre.isEmpty() && !nombre.matches("\\d+")) {
                        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
                    } else {
                        System.out.println("⚠️ Entrada inválida. Inténtelo de nuevo ⚠️");
                    }
                }

                String apellido1 = "";
                while (apellido1.isEmpty()) {
                    System.out.println("\n👤 Primer apellido: ");
                    apellido1 = sc.nextLine().trim();
                    if (!apellido1.isEmpty() && !apellido1.matches("\\d+")) {
                        apellido1 = apellido1.substring(0, 1).toUpperCase() + apellido1.substring(1).toLowerCase();
                    } else {
                        System.out.println("⚠️ Entrada inválida. Inténtelo de nuevo ⚠️");
                    }
                }

                String apellido2 = "";
                while (apellido2.isEmpty()) {
                    System.out.println("\n👤 Segundo apellido: ");
                    apellido2 = sc.nextLine().trim();
                    if (!apellido2.isEmpty() && !apellido2.matches("\\d+")) {
                        apellido2 = apellido2.substring(0, 1).toUpperCase() + apellido2.substring(1).toLowerCase();
                    } else {
                        System.out.println("⚠️ Entrada inválida. Inténtelo de nuevo ⚠️");
                    }
                }

                String nif = "";
                while (nif.isEmpty()) {
                    System.out.println("\n👤 NIF: ");
                    nif = sc.next().toUpperCase().trim();

                    if (!UtilidadesPersona.esNIFValido(nif)) {
                        System.out.println("⚠️ NIF inválido ⚠️");
                        nif = "";
                        sc.nextLine();
                    }
                }
                sc.nextLine();

                Sexo sexo = null;
                while (sexo == null) {
                    System.out.println("\n👤 Ingrese el sexo (MASCULINO, FEMENINO, NA): ");
                    try {
                        sexo = Sexo.valueOf(sc.next().trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ El sexo debe ser como lo indicado ⚠️");
                    }
                }
                sc.nextLine();


                String pais = "";
                while (pais.isEmpty()) {
                    System.out.println("\n👤 País de origen: ");
                    try{
                        pais = sc.nextLine().trim();
                        pais = pais.substring(0, 1).toUpperCase() + pais.substring(1).toLowerCase();

                        if (pais.isEmpty() && !pais.matches("\\d+")) {
                            System.out.println("⚠️ Entrada inválida. Inténtelo de nuevo ⚠️");
                        }
                    }catch(Exception e){
                        System.out.println("⚠️ Entrada inválida. Inténtelo de nuevo ⚠️");
                        }
                }

                String email = "";
                while (email.isEmpty()) {
                    System.out.println("\n👤 Ingrese el email: ");
                    email = sc.nextLine().trim();

                    if (!email.matches("\\w+@\\w+\\.\\w+")) {
                        System.out.println("⚠️ El email debe tener un formato válido ⚠️");
                        email = "";
                    }
                }

                String telefono = "";
                while (telefono.isEmpty()) {
                    System.out.println("\n👤 Ingrese el teléfono: ");
                    telefono = sc.nextLine().trim();

                    if (!telefono.matches("\\d{9}")) {
                        System.out.println("⚠️ El teléfono debe tener 9 números ⚠️");
                        telefono = "";
                    }
                }

////////////////////////////////////////////// CONDUCTOR /////////////////////////////////////////////////////////////////////////////////////////////////


                System.out.println("\n**** \uD83D\uDEA6 DATOS DEL CONDUCTOR \uD83D\uDEA6 *****\n");

                LocalDate fechaCarnet = null;
                while (fechaCarnet == null) {

                    System.out.println("\n\uD83D\uDEA6 Ingrese la fecha de expedición del carnet de conducir (yyyy-MM-dd): ");
                    try {
                        fechaCarnet = LocalDate.parse(sc.next().trim());

                        if (fechaCarnet.isAfter(LocalDate.now())) {
                            System.out.println("⚠️ La fecha no puede ser posterior a la actual. Inténtelo de nuevo ⚠️");
                            fechaCarnet = null;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("⚠️ Ingrese una fecha en formato válido ⚠️");

                    }
                }
                sc.nextLine();

                int puntosCarnet = 0;
                while (puntosCarnet < 1 || puntosCarnet > 15) {
                    System.out.println("\n\uD83D\uDEA6 Puntos del carnet: ");
                    try {
                        puntosCarnet = Integer.parseInt(sc.nextLine().trim());

                        if (puntosCarnet > 15 || puntosCarnet < 1) {
                            System.out.println("⚠️ Los puntos deben estar entre 1 y 15 ⚠️");
                            puntosCarnet = 0;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Entrada inválida. Ingrese un número válido ⚠️");
                    }
                }

                int anyosAsegurado = -1;
                while (anyosAsegurado == -1) {
                    System.out.println("\n\uD83D\uDEA6 Años asegurado: ");
                    try {
                        anyosAsegurado = Integer.parseInt(sc.nextLine().trim());

                        if (anyosAsegurado < 0) {
                            System.out.println("⚠️ El número de años asegurado no puede ser negativo ⚠️");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Entrada inválida. Ingrese un número válido ⚠️");
                        anyosAsegurado = -1;
                    }
                }

                // Conductor principal
                if (opcionConductor == 1) {
                    personaGeneral = new Persona(nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, sexo, pais, email, telefono);
                    conductorGeneral = new Conductor(nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, sexo, pais, email, telefono, fechaCarnet, puntosCarnet, anyosAsegurado);
                }

                //Conductores ocasionales
                if (opcionConductor == 2) {
                    Conductor conductorOcasional = new Conductor(nombre, apellido1, apellido2, nif, fechaNacimiento, direccion, sexo, pais, email, telefono, fechaCarnet, puntosCarnet, anyosAsegurado);
                    conductoresOcasionales.add(conductorOcasional);
                }

                opcionConductor = 0;

            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número válido ⚠️");
                sc.nextLine();
            }

        }


////////////////////////////////////////////// VEHICULO /////////////////////////////////////////////////////////////////////////////////////////////////


            System.out.println("**** 🚗 DATOS DEL VEHÍCULO 🛵 *****\n");

            int respuestaVehiculo = 0;
            while (respuestaVehiculo == 0) {
                System.out.println("\n¿Quiere registrar un 🚗 COCHE (1) o una 🛵 MOTO (2)?");

                try{
                    respuestaVehiculo = sc.nextInt();
                    if (respuestaVehiculo != 1 && respuestaVehiculo != 2) {
                        System.out.println("⚠️ La respuesta solo puede ser 1 ó 2 ⚠️");
                        respuestaVehiculo = 0;
                    }

                }catch (Exception e) {
                    System.out.println("⚠️ La respuesta solo puede ser 1 ó 2 ⚠️");
                    sc.nextLine();
                }
            }
            sc.nextLine();

            Marca marca = null;
            while (marca == null) {
                System.out.println("\n🚗 Ingrese la marca: 🛵");
                try {
                    String marcaString = sc.nextLine().trim();
                    String marcaCap = marcaString.substring(0, 1).toUpperCase() + marcaString.substring(1);

                    SoporteVehiculos sop = SoporteVehiculos.getInstance();

                    if (marcaCap.isEmpty()) {
                        System.out.println("⚠️ La marca no puede estar vacía ⚠️");
                    } else if (sop.esMarcaValida(marcaCap)) {
                        marca = sop.getMarcaByName(marcaCap);
                    } else {
                        System.out.println("⚠️ La marca no existe ⚠️");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ La marca no es válida, introduce una válida ⚠️");
                    sc.nextLine();
                }
            }

            Modelo modelo = null;
            while (modelo == null) {
                System.out.println("\n🚗 Ingrese el modelo: 🛵");
                try {
                    String modeloString = sc.nextLine().trim();
                    String modeloCap = modeloString.substring(0, 1).toUpperCase() + modeloString.substring(1);

                    SoporteVehiculos sop = SoporteVehiculos.getInstance();

                    if (modeloCap.isEmpty()) {
                        System.out.println("⚠️ El modelo no puede estar vacío ⚠️");
                    } else if (sop.esModeloValido(marca.toString(), modeloCap)) {
                        modelo = marca.getModelo(modeloCap);
                    } else {
                        System.out.println("⚠️ El modelo no existe ⚠️");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️ El modelo no existe ⚠️");
                    sc.nextLine();
                }
            }

            String matricula = "";
            while (matricula.isEmpty()) {
                System.out.println("\n🚗 Ingrese la matrícula: 🛵");
                String matriculaString = sc.nextLine().toUpperCase().trim();

                if (matriculaString.isEmpty()) {
                    System.out.println("⚠️ La matrícula no puede estar vacía ⚠️");
                } else if (UtilidadesVehiculo.esMatriculaValida(matriculaString)) {
                    matricula = matriculaString;
                } else {
                    System.out.println("⚠️ La matrícula no es válida ⚠️");
                    sc.nextLine();
                }
            }

            LocalDate fechaMatriculacion = null;
            while (fechaMatriculacion == null) {
                System.out.println("\n🚗 Ingrese la fecha de matriculación (yyyy-MM-dd): 🛵");
                try {
                    fechaMatriculacion = LocalDate.parse(sc.next().trim());

                    if (fechaMatriculacion.isAfter(LocalDate.now())) {
                        System.out.println("⚠️ La fecha no puede ser posterior a la actual. Inténtelo de nuevo ⚠️");
                        fechaMatriculacion = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("⚠️ Ingrese una fecha en formato válido ⚠️");
                    sc.nextLine(); // Limpia el buffer
                }
            }
            sc.nextLine(); // Limpia el buffer después de next()

            String color = "";
            while (color.isEmpty()) {
                System.out.println("\n🚗 Ingrese el color: 🛵");
                try{
                    color = sc.nextLine().trim();
                    color = color.substring(0, 1).toUpperCase() + color.substring(1);

                    if (color.isEmpty()) {
                        System.out.println("⚠️ El campo no puede estar vacío ⚠️");
                        sc.nextLine();
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ El campo no puede estar vacío ⚠️");
                    sc.nextLine();
                }

            }


////////////////////////////////////////////// COCHE /////////////////////////////////////////////////////////////////////////////////////////////////

            Coche cocheGeneral = null;
            Moto motoGeneral = null;

            if (respuestaVehiculo == 1) {
                System.out.println("\n**** 🚗 LOS DATOS DEL COCHE 🚗 *****\n");

                int numeroPuertas = 0;
                while (numeroPuertas == 0) {
                    System.out.println("\n🚗 Ingrese el número de puertas (2-5): ");
                    try {
                        numeroPuertas = sc.nextInt();

                        if (numeroPuertas < 2 || numeroPuertas > 5) {
                            System.out.println("⚠️ El número de puertas debe estar entre 2 y 5 ⚠️");
                            numeroPuertas = 0;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ El número de puertas no es válido ⚠️");
                    }
                }
                sc.nextLine();

                TipoCombustible tipoCombustible = null;
                while (tipoCombustible == null) {
                    System.out.println("\n🚗 Ingrese el tipo de combustible (GASOLINA, DIESEL, ELECTRICO, HIBRIDO): ");
                    try {
                        tipoCombustible = TipoCombustible.valueOf(sc.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ El tipo de combustible no es válido ⚠️");
                    }
                }

                Traccion traccion = null;
                while (traccion == null) {
                    System.out.println("\n🚗 Ingrese el tipo de tracción (DELANTERA, TRASERA, INTEGRAL): ");
                    try {
                        traccion = Traccion.valueOf(sc.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("⚠️ El tipo de tracción no es válido ⚠️");
                    }
                }

                boolean esTodoTerreno = false;
                String rTodoTerrenoString = "";
                while (rTodoTerrenoString.isEmpty()) {
                    System.out.println("\n🚗 ¿Es Todo-Terreno? (S/N):");
                    rTodoTerrenoString = sc.nextLine().toUpperCase().trim();

                    if (rTodoTerrenoString.equals("S")) {
                        esTodoTerreno = true;
                    } else if (rTodoTerrenoString.equals("N")) {
                        esTodoTerreno = false;
                    } else {
                        System.out.println("⚠️ La respuesta debe ser S/N ⚠️");
                        rTodoTerrenoString = "";
                    }
                }

                cocheGeneral = new Coche(marca, modelo, matricula, fechaMatriculacion, color, personaGeneral, numeroPuertas, tipoCombustible, traccion, esTodoTerreno);
                System.out.println("\n✅ Vehículo registrado con éxito ✅\n");
            }

////////////////////////////////////////////// MOTO /////////////////////////////////////////////////////////////////////////////////////////////////

            if (respuestaVehiculo == 2) {
                System.out.println("\n**** 🛵 DATOS DE LA MOTO 🛵 *****\n");

                int cilindradaCC = 0;
                while (cilindradaCC == 0) {
                    System.out.println("\n🛵 Ingrese la cilindrada (49, 125, 250, ó 500): ");
                    try {
                        cilindradaCC = sc.nextInt();

                        if (cilindradaCC != 49 && cilindradaCC != 125 && cilindradaCC != 250 && cilindradaCC != 500) {
                            System.out.println("⚠️ Las cilindradas (cc) no son correctas ⚠️");
                            cilindradaCC = 0;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ El número de cilindradas no es correcto ⚠️");
                    }
                }
                sc.nextLine();

                boolean tieneSidecar = false;
                String rTieneSidecar = "";
                while (rTieneSidecar.isEmpty()) {
                    System.out.println("\n🛵 ¿Tiene sidecar? (S/N):");
                    rTieneSidecar = sc.nextLine().toUpperCase().trim();

                    if (rTieneSidecar.equals("S")) {
                        tieneSidecar = true;
                    } else if (rTieneSidecar.equals("N")) {
                        tieneSidecar = false;
                    } else {
                        System.out.println("⚠️ La respuesta debe ser S/N ⚠️");
                        rTieneSidecar = "";
                    }
                }

                motoGeneral = new Moto(marca,modelo,matricula,fechaMatriculacion,color,personaGeneral,cilindradaCC,tieneSidecar);
                System.out.println("\n✅ Vehículo registrado con éxito ✅\n");

            }




////////////////////////////////////////// COTIZACIÓN //////////////////////////////////////////////////////////////////////////////

            LocalDate fechaCotizacion = LocalDate.now();

            LocalDate fechaInicio = null;

            while (fechaInicio == null) {

                System.out.println("\n\uD83D\uDCC4 Ingrese la fecha del inicio de la cotización (yyyy-MM-dd): ");
                try {
                    fechaInicio = LocalDate.parse(sc.next().trim());

                    if (fechaInicio.isBefore(LocalDate.now())) {
                        System.out.println("⚠️ La fecha no puede ser anterior a la actual. Inténtelo de nuevo ⚠️");
                        fechaInicio = null;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("⚠️ Ingrese una fecha en formato válido ⚠️");
                }
            }
            sc.nextLine(); // Limpia el buffer después de next()

            boolean tieneAparcamiento = false;
            String rtieneAparcamiento = "";

            while (rtieneAparcamiento.isEmpty()) {
                System.out.println("\n\uD83D\uDCC4 ¿Tiene aparcamiento privado? (S/N):");
                rtieneAparcamiento = sc.nextLine().toUpperCase().trim();

                if (rtieneAparcamiento.equals("S")) {
                    tieneAparcamiento = true;
                } else if (rtieneAparcamiento.equals("N")) {
                    tieneAparcamiento = false;
                } else {
                    System.out.println("⚠️ La respuesta debe ser S/N ⚠️");
                    rtieneAparcamiento = "";
                }
            }

            int numSin5 = 10;
            while (numSin5 == 10) {
                System.out.println("\n\uD83D\uDCC4 Números de siniestros en los últimos 5 años: ");
                try {
                    numSin5 = sc.nextInt();

                    if (numSin5 > 6 || numSin5 < 0) {
                        System.out.println("❌ No puedes ser asegurado ❌");
                        numSin5 = 10;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ No puedes ser asegurado ❌");
                }
            }

            Cotizacion cotizacion = new Cotizacion();

            if (respuestaVehiculo == 1){
                cotizacion = new Cotizacion(fechaCotizacion, fechaInicio, cocheGeneral, personaGeneral, conductorGeneral, conductoresOcasionales, tieneAparcamiento, numSin5, null);
            }
            if (respuestaVehiculo == 2){
                cotizacion = new Cotizacion(fechaCotizacion, fechaInicio, motoGeneral, personaGeneral, conductorGeneral, conductoresOcasionales, tieneAparcamiento, numSin5, null);
            }


            System.out.println("\n" + "\uD83D\uDCDD Cotización:\n\n" + "\tTerceros: " + cotizacion.getPrecioTERC() + "€ - " + "Terceros ampliados: " + cotizacion.getPrecioTAMP() + "€ - " + "Todo riesgo: " + cotizacion.getPrecioTRIE() + "€");


            int modalidadElegida = 0;
            while (modalidadElegida == 0) {
                System.out.println("\n\uD83D\uDCC4 ¿Qué modalidad prefiere? Terceros(3), Terceros ampliados(2), Todo riesgo(1), Salir de programa(4): ");
                try {
                    modalidadElegida = sc.nextInt();

                    if (modalidadElegida == 1) {
                        cotizacion.setModalidadElegida(Cotizacion.modalidadElegida.PrecioTRIE);

                    } else if (modalidadElegida == 2) {
                        cotizacion.setModalidadElegida(Cotizacion.modalidadElegida.PrecioTAMP);

                    } else if (modalidadElegida == 3) {
                        cotizacion.setModalidadElegida(Cotizacion.modalidadElegida.PrecioTERC);

                    } else if (modalidadElegida == 4) {
                        System.out.println("Gracias por contactar con Aseguradora Aseg...");
                        System.exit(0);

                    } else {
                        System.out.println("⚠️ La respuesta debe ser 1, 2, 3 ó 4 ⚠️");
                        modalidadElegida = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ La respuesta debe ser 1, 2, 3 ó 4 ⚠️");
                }

            }
            sc.nextLine();

            AnualidadPoliza.ModoPago modoPago = null;
            while (modoPago == null) {
                System.out.println("\n📄 ¿Qué modo de pago prefiere? IBAN(1) o Tarjeta(2): ");
                try {
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1:
                            modoPago = AnualidadPoliza.ModoPago.IBAN;
                            break;
                        case 2:
                            modoPago = AnualidadPoliza.ModoPago.Tarjeta;
                            break;
                        default:
                            System.out.println("⚠️ La respuesta debe ser 1 ó 2 ⚠️");
                    }
                } catch (Exception e) {
                    System.out.println("⚠️ Entrada inválida. Ingrese 1 ó 2 ⚠️");
                    sc.nextLine();
                }
            }


            int pagoFraccionado = 0;
            boolean isPagoFraccionado = false;
            while (pagoFraccionado == 0) {
                System.out.println("\n\uD83D\uDCC4 ¿Qué modo de pago prefiere? Fraccionado(1) o Sin Fraccionar(2): ");
                try {
                    pagoFraccionado = sc.nextInt();

                    if (pagoFraccionado == 1) {
                        isPagoFraccionado = true;

                    } else if (pagoFraccionado == 2) {
                        isPagoFraccionado = false;

                    } else{
                        System.out.println("⚠️ La respuesta debe ser 1 ó 2 ⚠️");
                        pagoFraccionado = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ La respuesta debe ser 1 ó 2 ⚠️");
                }
            }
            sc.nextLine();

            System.out.println("**** \uD83D\uDCDC DATOS DE LA POLIZA \uD83D\uDCDC *****\n");

            LocalDate fechaInicioAnualidad = LocalDate.now();
            AnualidadPoliza anualidadPoliza = new AnualidadPoliza(AnualidadPoliza.EstadoPoliza.Vigente, null, cotizacion, modoPago, isPagoFraccionado, fechaInicioAnualidad, null);

            List<AnualidadPoliza> listAnualidadPoliza = new ArrayList<>();
            listAnualidadPoliza.add(anualidadPoliza);
            Poliza poliza = new Poliza(listAnualidadPoliza);
            System.out.println(poliza);


        }
    }



