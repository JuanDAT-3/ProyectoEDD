package EI;

public class ProductoBB {
    private String nombre;
    private float precio;
    private int cantidad;

    public ProductoBB(String nombre, float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString(){
        return ("Producto: " + nombre +", Precio: " + precio + ", Cantidad: " + cantidad);
    }

}
