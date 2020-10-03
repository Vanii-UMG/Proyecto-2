package Modelo;


public class Individual extends Cliente {
    private String dpi;

    public Individual(String dpi) {
        this.dpi = dpi;
    }

    public Individual(String dpi, String nombre, String apellido, int edad,int id) {
        super(nombre, apellido, edad, id);
        this.dpi = dpi;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    
}
