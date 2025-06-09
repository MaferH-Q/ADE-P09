package Graph;

/**
 * 2.1 - Clase Edge<E> que permite representar aristas en un grafo.
 * Cada arista contiene una referencia al vértice destino y un posible peso.
 */
public class Edge<E> {

    private Vertex<E> refDest;   // conexión a un vértice destino
    private int weight;          // Peso de la arista, -1 si no tiene peso

    /**
     * Constructor para aristas sin peso (por defecto -1)
     */
    public Edge(Vertex<E> refDest) {
        this(refDest, -1);
    }

    /**
     * Constructor para aristas con peso específico
     */
    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    /**
     * Devuelve el vértice destino de la arista
     */
    public Vertex<E> getRefDest() {
        return refDest;
    }

    /**
     *Devuelve el peso asociado a la arista
     */
    public int getWeight() {
        return weight;
    }

    /**
     * implementación de equals para comparación de aristas
     * Considera dos aristas iguales si apuntan al mismo vértice destino
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge<?>) {
            Edge<E> e = (Edge<E>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    /**
     *  representación textual clara para imprimir aristas
     */
    @Override
    public String toString() {
        if (this.weight > -1)
            return refDest.getData() + " [" + this.weight + "], ";
        else
            return refDest.getData() + ", ";
    }
}
