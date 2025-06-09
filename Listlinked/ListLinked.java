package Listlinked;


/**
 * Lista enlazada simple genérica.
 * Permite agregar, eliminar, buscar e imprimir elementos.
 */
public class ListLinked<T> {

    // Nodo interno que almacena un dato y un enlace al siguiente nodo
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Primer nodo de la lista
    private int size;     // Número de elementos en la lista

    // Constructor: crea una lista vacía
    public ListLinked() {
        head = null;
        size = 0;
    }

    /**
     * Agrega un elemento al final de la lista.
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        size++;
    }

    /**
     * Elimina la primera ocurrencia del elemento.
     * Retorna true si se eliminó, false si no se encontró.
     */
    public boolean remove(T element) {
        if (head == null) return false;

        if (head.data.equals(element)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(element)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
            return true;
        }

        return false;
    }

    /**
     * Retorna true si la lista contiene el elemento.
     */
    public boolean contains(T element) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Devuelve el elemento en la posición indicada (0-based).
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Devuelve el índice del elemento si existe, o -1 si no.
     */
    public int indexOf(T element) {
        Node<T> temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data.equals(element)) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    /**
     * Devuelve la cantidad de elementos en la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Devuelve una representación en texto de todos los elementos de la lista.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;

        while (temp != null) {
            sb.append(temp.data.toString());
            temp = temp.next;
        }

        return sb.toString();
    }
}
