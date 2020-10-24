package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Orden {
    public static int sigIdOrden = 1;
    private int id;
    private Cliente cliente;
    //private ItemOrden item1;
    //private ItemOrden item2;
    private ArrayList<ItemOrden> items;
    private Date fechaOrden;
    private double precioEnvio;
    private double total;
    private String tipoEnvio;
    private String estado;
    private int diasEnvio;
    private int itemLine = 0;


    public Orden(){
        this.id = sigIdOrden++;
        this.total = 0.0;
        this.fechaOrden = new Date();
    }

    public Orden(Date pFecha) {
        this.fechaOrden = pFecha;
    }

    public Orden(int pCliente, Date pFecha) {
        this.id = sigIdOrden++;
        this.items = new ArrayList<ItemOrden>();
        this.cliente = searchCliente(pCliente);
        this.fechaOrden = pFecha;
        this.total = 0.0;

        this.estado = "Generada";
        this.tipoEnvio = "Ninguno";
        this.precioEnvio = 0;
        this.diasEnvio = 0;
    }

    public int getItemLine(){
        return this.itemLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemOrden> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemOrden> items) {
        this.items = items;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDiasEnvio() {
        return diasEnvio;
    }

    public void setDiasEnvio(int diasEnvio) {
        this.diasEnvio = diasEnvio;
    }

    public double getTotalOrden() {
        double retTotal = 0;
        if(Utilerias.getNombreClase(this.cliente.getClass()) == Utilerias.getNombreClase(Empresas.class)){
            Empresas clientew = (Empresas) this.cliente;
            retTotal = this.total - (this.total * (Double.valueOf(clientew.getDescuento())/100));
        }else{
            retTotal = this.total;
        }

        return retTotal;

    }

    private Cliente searchCliente (int pCliente) {
        Cliente cliente = null;
        for(int i=0; i<DataSistema.clientes.size(); i++){
            if(DataSistema.clientes.get(i).getId() == pCliente){
                cliente = DataSistema.clientes.get(i);
                break;
            }
        }
        return cliente;
    }

    public void addItems(int cantidad, int idProducto){
        if(validProductId(idProducto)) {
            ItemOrden newItem = new ItemOrden(++this.itemLine, cantidad, idProducto);
            this.items.add(newItem);
            this.total = this.total + newItem.getTotalItem();
        }
    }

    public void deleteItems(ItemOrden itemOrden){
        this.items.remove(itemOrden);
        this.itemLine--;
        recalcTotal();
    }

    public void updateItems(int linea, int cantidad, Producto producto){
        this.items.get(linea-1).setCantidad(cantidad);
        this.items.get(linea-1).setProducto(producto);
        recalcTotal();
    }

    private void recalcTotal(){
        this.total = 0;
        for(int i=0; i<this.items.size();i++){
            this.total += this.items.get(i).getTotalItem();
        }
    }

    private Timestamp ActualDateTime(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    private boolean validProductId(int pIdProducto) {
        boolean resp = false;
        for (int i = 0; i < DataSistema.productos.size(); i++) {
            if (DataSistema.productos.get(i).getId() == pIdProducto) {
                resp = true;
                break;
            }
        }
        return resp;
    }

}
