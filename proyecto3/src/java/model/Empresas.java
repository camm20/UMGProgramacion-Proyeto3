package model;

public class Empresas extends Cliente {
    private String contacto;
    private int descuento;

    public Empresas(int id, String nombres, String apellidos, String direccion, String departamento, String contacto, int descuento) {
        super(id, nombres, apellidos, direccion, departamento);
        this.contacto = contacto;
        this.descuento = descuento;
    }
    
    public Empresas(String nombres, String apellidos, String direccion, String departamento, String contacto, int descuento) {
        super(nombres, apellidos, direccion, departamento);
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

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", contacto='" + contacto + '\'' +
                ", descuento='" + descuento;
    }
}
