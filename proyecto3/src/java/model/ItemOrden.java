package model;

public class ItemOrden {
    protected int noLinea;
    protected int cantidad;
    protected Producto producto;

    public ItemOrden(int pNoLinea, int pCantidad, int pIdProducto) {
        this.noLinea = pNoLinea;
        this.cantidad = pCantidad;
        this.producto = searchProduct(pIdProducto);
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

    private Producto searchProduct(int pIdProducto) {
        Producto producto = null;

        for (int i = 0; i < DataSistema.productos.size(); i++) {
            if (DataSistema.productos.get(i).getId() == pIdProducto) {
                producto = DataSistema.productos.get(i);
                break;
            }
        }

        return producto;
    }

}
