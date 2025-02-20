package modelos;

public enum TipoVia {
    //Atributos
    CALLE("Calle"),
    AVENIDA("Avenida"),
    PLAZA("Plaza"),
    PLAZOLETA("Plazoleta"),
    CALLEJON("Callejón");

    private String tipo;

    //Constructor
    TipoVia(String tipo) {
        this.tipo = tipo;
    }

    //Getter y setter
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //ToString
    public String toString() {
        return tipo;
    }
}
