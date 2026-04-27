package EI;

public class ProteinaMS {
    private String nombre;
    private float puntoIsoelectrico;
    private float hidrofobiaPromedio;

    public ProteinaMS(String nombre, float puntoIsoelectrico, float hidrofobiaPromedio) {
        this.nombre = nombre;
        this.puntoIsoelectrico = puntoIsoelectrico;
        this.hidrofobiaPromedio = hidrofobiaPromedio;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPuntoIsoelectrico() {
        return puntoIsoelectrico;
    }

    public float getHidrofobiaPromedio() {
        return hidrofobiaPromedio;
    }

    @Override
    public String toString() {
        return "Proteina: " + nombre
                + ", pI: " + puntoIsoelectrico
                + ", Hidrofobia Promedio: " + hidrofobiaPromedio;
    }
}
