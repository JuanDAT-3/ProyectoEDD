package EI;

public class EstudianteIS
{
    private String nombre;
    private int nota;
    private int edad;

    public EstudianteIS(String nombre, int nota, int edad)
    {
        this.nombre = nombre;
        this.nota = nota;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getNota()
    {
        return nota;
    }

    public int getEdad()
    {
        return edad;
    }

    public String toString()
    {
        return nombre + " - Nota: " + nota + " - Edad: " + edad;
    }
}