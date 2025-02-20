package modelos;

public enum Traccion {
    //Atributos
    DELANTERA("Delantera"),
    TRASERA("Trasera"),
    INTEGRAL("Integral");
    private String traccion;

    //Constructor
    Traccion(String traccion) {
        this.traccion = traccion;
    }

    //Getter y setter
    public String getTraccion() {
        return traccion;
    }
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    //ToString
    public String toString() {
        return traccion;
    }
}
