package EI;

import TDAs.DoublyLinkedList;

public class InventarioBB {
    private DoublyLinkedList<ProductoBB> inventario;

    public InventarioBB() {
        this.inventario = new DoublyLinkedList<>();
    }

    public void agregarProducto(String n, float p, int c){
        inventario.addLast(new ProductoBB(n,p,c));
    }

    public void ordenarPorNombre(){
        inventario.bubbleSort((p1,p2)->p1.getNombre().compareTo(p2.getNombre()));
    }

    public void ordenarPorPrecio(){
        inventario.bubbleSort((p1,p2)-> Float.compare(p1.getPrecio(), p2.getPrecio()));
    }

    public void ordenarPorCantidad(){
        inventario.bubbleSort((p1,p2)-> Integer.compare(p1.getCantidad(), p2.getCantidad()));
    }

    public void imprimirInventario(){
        for(ProductoBB p : inventario){
            System.out.println(p);
        }
    }

}