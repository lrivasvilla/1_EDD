import java.time.LocalDate;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hola Mundo!");
    }

    public static void fechaActual(String[] args) {
        System.out.println(LocalDate.now());
    }
}