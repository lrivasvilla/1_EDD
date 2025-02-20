package modelos;

public enum Sexo {
    //Atributos
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    NA("N/A");
    private String sexo;

    //Constructor
    Sexo(String sexo) {
        this.sexo = sexo;
    }

    // Getter y setter
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //ToString
    public String toString() {
        return sexo;
    }
}
