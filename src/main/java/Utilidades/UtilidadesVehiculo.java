package Utilidades;

import modelos.Persona;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesVehiculo {
    public static boolean esMatriculaValida(String matricula) {
        if (matricula == null) {
            return false;
        }

        // Matricula normal
        if (matricula.matches("^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$")){
            return true;
        }

        List<String> fuerzasEstado = new ArrayList<>();
        fuerzasEstado.add("CGPC[0-9]{4}");
        fuerzasEstado.add("CME[0-9]{4}");
        fuerzasEstado.add("CNP[0-9]{4}[A-Z]{2}");
        fuerzasEstado.add("E[0-9]{4}");
        fuerzasEstado.add("EA[0-9]{6}");
        fuerzasEstado.add("ET[0-9]{6}");
        fuerzasEstado.add("FN[0-9]{5}");
        fuerzasEstado.add("PGC[0-9]{4}[A-Z]{1}");


        for (int i = 0; i < fuerzasEstado.size(); i++) {
            if (matricula.matches(fuerzasEstado.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static int calculaEdad(Vehiculo vehiculo) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMatriculacion = vehiculo.getFechaMatriculacion();
        Period periodo = Period.between(fechaMatriculacion, fechaActual);
        return periodo.getYears();
    }

    public static List<Vehiculo> getVehiculos(List<Vehiculo> listaVehiculos, Persona p){
        List<Vehiculo> vehiculos = new ArrayList<>();

        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getDuenyoActual().equals(p)){
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }

    public static boolean validaFechaMatriculacion(LocalDate fechaMat){
        LocalDate fechaActual = LocalDate.now();
        if (fechaMat.isAfter(fechaActual)) {
            return false;
        }
        return true;
    }


}
