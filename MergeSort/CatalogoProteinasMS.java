package EI;

import TDAs.DoublyLinkedList;

public class CatalogoProteinasMS {
    private DoublyLinkedList<ProteinaMS> proteinas;

    public CatalogoProteinasMS() {
        this.proteinas = new DoublyLinkedList<>();
    }

    public void agregarProteina(String nombre, float puntoIsoelectrico, float hidrofobiaPromedio) {
        proteinas.addLast(new ProteinaMS(nombre, puntoIsoelectrico, hidrofobiaPromedio));
    }

    public void ordenarPorPuntoIsoelectrico() {
        proteinas.mergeSort((p1, p2) -> Float.compare(p1.getPuntoIsoelectrico(), p2.getPuntoIsoelectrico()));
    }

    public void ordenarPorHidrofobiaPromedio() {
        proteinas.mergeSort((p1, p2) -> Float.compare(p1.getHidrofobiaPromedio(), p2.getHidrofobiaPromedio()));
    }

    public void imprimirCatalogo() {
        for (ProteinaMS p : proteinas) {
            System.out.println(p);
        }
    }
}
