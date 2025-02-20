package modelos;

public enum TipoCombustible {
    //Atributos
    GASOLINA("Gasolina"),
    DIESEL("Diesel"),
    ELECTRICO("Eléctrico"),
    HIBRIDO("Hibrido");
    private String combustible;

    //Constructor
    TipoCombustible(String combustible){
        this.combustible = combustible;
    }

    //Getter y setter
    public String getCombustible(){
        return combustible;
    }
    public void setCombustible(String combustible){
        this.combustible = combustible;
    }

    //ToString
    public String toString() {
        return combustible;
    }
}
