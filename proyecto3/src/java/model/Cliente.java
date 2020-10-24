package model;

public class Cliente {
    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String departamento;

    public Cliente(int id, String nombres, String apellidos, String direccion, String departamento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.departamento = departamento;
    }
    
    public Cliente(String nombres, String apellidos, String direccion, String departamento) {
        
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return  "[" + Utilerias.getNombreClase(this.getClass()) + "] " +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", departamento='" + departamento + '\'';
    }
}
