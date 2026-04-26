package EI;

public class MainInsertionSort
{
    public static void main(String[] args)
    {
        UniversidadIS u = new UniversidadIS();

        u.agregarEstudiante("Carlos",70,20);
        u.agregarEstudiante("Ana",95,19);
        u.agregarEstudiante("Luis",80,22);
        u.agregarEstudiante("Maria",85,21);

        System.out.println("ORDENAMIENTO POR NOMBRE:");
        u.ordenarPorNombre();
        u.imprimir();

        System.out.println("\nORDENAMIENTO POR NOTA:");
        u.ordenarPorNota();
        u.imprimir();

        System.out.println("\nORDENAMIENTO POR EDAD:");
        u.ordenarPorEdad();
        u.imprimir();
    }
}
