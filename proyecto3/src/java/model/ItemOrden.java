package model;

public class ItemOrden {
    protected int noLinea;
    protected int cantidad;
    protected Producto producto;

    public ItemOrden(int pNoLinea, int pCantidad, Producto producto) {
        this.noLinea = pNoLinea;
        this.cantidad = pCantidad;
        this.producto = producto;
    }

    public int getNoLinea() {
        return noLinea;
    }

    public void setNoLinea(int noLinea) {
        this.noLinea = noLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "[" + Utilerias.getNombreClase(this.getClass()) + "] " +
                "noLinea=" + noLinea +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }

    public double getTotalItem(){
        return this.producto.getPrecio() * cantidad;
    }

}
