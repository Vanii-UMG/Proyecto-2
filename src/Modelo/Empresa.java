package Modelo;

public class Empresa extends Cliente{
    private String contacto;
    private int descuento;

    public Empresa(String contacto, String nombre, String apellido, int edad, int descuento, int id) {
        super(nombre, apellido, edad, id);
        this.contacto = contacto;
        this.descuento = descuento;
        
        
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    
    
}
