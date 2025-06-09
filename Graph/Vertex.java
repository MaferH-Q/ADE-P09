package Graph;

import Listlinked.ListLinked;
/**
 *  2.1 - Clase Vertex<E> que representa un vértice del grafo.
 * Cada vértice contiene un dato identificador y una lista de adyacencia (aristas).
 */
public class Vertex<E> {

    private E data;  // Dato genérico que identifica al vértice (como "A", "1", etc.)
    
    protected ListLinked<Edge<E>> listAdj;  // Lista enlazada de aristas (adyacencias)

    /**
     * Constructor del vértice. Inicializa el dato y la lista de adyacencias vacía.
     */
    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<Edge<E>>();  // Uso de lista enlazada propia
    }

    /**
     * Devuelve el dato asociado al vértice.
     */
    public E getData() {
        return data;
    }

    /**
     * Sobrescribe equals para comparar vértices por su dato.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex<?>) {
            Vertex<E> v = (Vertex<E>) o;
            return this.data.equals(v.data);  // Compara por contenido, no por referencia
        }
        return false;
    }

    /**
     * Devuelve una representación en texto del vértice y sus adyacencias.
     */
    @Override
    public String toString() {
        return this.data + " --> " + this.listAdj.toString() + "\n";
    }
}