package model;

public class Individual extends Cliente {
    private String DPI;

    public Individual(int id, String nombres, String apellidos, String direccion, String departamento, String DPI) {
        super(id, nombres, apellidos, direccion, departamento);
        this.DPI = DPI;
    }
    
    public Individual(String nombres, String apellidos, String direccion, String departamento, String DPI) {
        super(nombres, apellidos, direccion, departamento);
        this.DPI = DPI;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", DPI='" + DPI ;
    }
}
