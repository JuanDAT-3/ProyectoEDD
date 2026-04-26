package EI;

import TDAs.DoublyLinkedList;

public class UniversidadIS
{
    private DoublyLinkedList<EstudianteIS> estudiantes;

    public UniversidadIS()
    {
        estudiantes = new DoublyLinkedList<>();
    }

    public void agregarEstudiante(String n, int nota, int edad)
    {
        estudiantes.addLast(new EstudianteIS(n,nota,edad));
    }

    public void ordenarPorNombre()
    {
        estudiantes.insertionSort((a,b)->a.getNombre().compareTo(b.getNombre()));
    }

    public void ordenarPorNota()
    {
        estudiantes.insertionSort((a,b)->Integer.compare(a.getNota(), b.getNota()));
    }

    public void ordenarPorEdad()
    {
        estudiantes.insertionSort((a,b)->Integer.compare(a.getEdad(), b.getEdad()));
    }

    public void imprimir()
    {
        for(EstudianteIS e : estudiantes)
        {
            System.out.println(e);
        }
    }
}