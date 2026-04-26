package EI;

import TDAs.DoublyLinkedList;

public class MainBubbleSort {
    public static void main(String[] args) {
        InventarioBB inv = new InventarioBB();

        inv.agregarProducto("Camisetas",5.50f,10);
        inv.agregarProducto("Pantalones",7.80f,5);
        inv.agregarProducto("Hoodies",15.00f,3);
        inv.agregarProducto("Chaquetas",20.00f,1);
        inv.agregarProducto("Gorras",4.25f,15);

        // Ordenamiento por nombre
        System.out.println("ORDENAMIENTO POR NOMBRE:");
        inv.ordenarPorNombre();
        inv.imprimirInventario();

        // Ordenamiento por nombre
        System.out.println("ORDENAMIENTO POR PRECIO:");
        inv.ordenarPorPrecio();
        inv.imprimirInventario();

        // Ordenamiento por nombre
        System.out.println("ORDENAMIENTO POR CANTIDAD:");
        inv.ordenarPorCantidad();
        inv.imprimirInventario();
    }
}
