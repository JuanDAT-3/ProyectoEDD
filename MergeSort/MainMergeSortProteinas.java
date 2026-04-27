package EI;

public class MainMergeSortProteinas {
    public static void main(String[] args) {
        CatalogoProteinasMS catalogo = new CatalogoProteinasMS();

        catalogo.agregarProteina("Hemoglobina", 6.8f, -0.5f);
        catalogo.agregarProteina("Albumina", 4.7f, -0.9f);
        catalogo.agregarProteina("Insulina", 5.3f, -0.3f);
        catalogo.agregarProteina("Miosina", 5.4f, 0.2f);
        catalogo.agregarProteina("Citocromo C", 10.2f, 0.6f);

        System.out.println("ORDENAMIENTO POR PUNTO ISOELECTRICO:");
        catalogo.ordenarPorPuntoIsoelectrico();
        catalogo.imprimirCatalogo();

        System.out.println("\nORDENAMIENTO POR HIDROFOBIA PROMEDIO:");
        catalogo.ordenarPorHidrofobiaPromedio();
        catalogo.imprimirCatalogo();
    }
}
