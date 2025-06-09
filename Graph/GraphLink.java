package Graph;

import Listlinked.ListLinked;  //  Uso de lista enlazada implementada en paquete propio

/**
 2. Implementar el TAD Graph (grafo no dirigido) a partir del uso de listas enlazadas
 * Esta clase representa el grafo usando vértices y aristas como listas enlazadas.
 */
public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;  // estructura basada en lista enlazada de vértices

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();  //  constructor que inicializa la lista de vértices
    }

    /**
      método insertVertex (agrega un vértice al grafo)
     */
    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<>(data);
        if (!listVertex.contains(newVertex)) {
            listVertex.add(newVertex);
        }
    }

    /**
     inserción de aristas en ambas direcciones (grafo NO dirigido)
     */
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> vOri = getVertex(verOri);
        Vertex<E> vDes = getVertex(verDes);
        if (vOri != null && vDes != null && !vOri.listAdj.contains(new Edge<>(vDes))) {
            vOri.listAdj.add(new Edge<>(vDes));
            vDes.listAdj.add(new Edge<>(vOri));
        }
    }

    /**
      2.1.a) searchVertex(v)
     * Verifica si un vértice con el valor dado existe en el grafo
     */
    public boolean searchVertex(E v) {
        return getVertex(v) != null;
    }

    /**
     * Método auxiliar privado para obtener un vértice desde su dato
     */
    private Vertex<E> getVertex(E v) {
        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> current = listVertex.get(i);
            if (current.getData().equals(v)) {
                return current;
            }
        }
        return null;
    }

    /**
     *  2.1.b) searchEdge(v, z)
     * Verifica si existe una arista entre dos vértices
     */
    public boolean searchEdge(E v, E z) {
        Vertex<E> vertexV = getVertex(v);
        Vertex<E> vertexZ = getVertex(z);
        if (vertexV == null || vertexZ == null) {
            return false;
        }
        return vertexV.listAdj.contains(new Edge<>(vertexZ));
    }

    /**
     *2.2.b) removeEdge(v, z)
     * Elimina la arista entre dos vértices en ambas direcciones
     */
    public void removeEdge(E v, E z) {
        Vertex<E> vertexV = getVertex(v);
        Vertex<E> vertexZ = getVertex(z);
        if (vertexV != null && vertexZ != null) {
            vertexV.listAdj.remove(new Edge<>(vertexZ));
            vertexZ.listAdj.remove(new Edge<>(vertexV));
        }
    }

    /**
     * 2.2.a) removeVertex(v)
     * Elimina el vértice del grafo y también elimina las aristas que lo referencian
     */
    public void removeVertex(E v) {
        Vertex<E> target = getVertex(v);
        if (target != null) {
            for (int i = 0; i < listVertex.size(); i++) {
                Vertex<E> current = listVertex.get(i);
                current.listAdj.remove(new Edge<>(target));
            }
            listVertex.remove(target);
        }
    }

    /**
     * representación visual del grafo
     */
    public String toString() {
        return listVertex.toString();
    }

    /**
     * 2.2.c) dfs(v)
     * Realiza un recorrido en profundidad desde el vértice v
     */
    public void dfs(E v) {
        Vertex<E> start = getVertex(v);
        if (start == null) return;

        boolean[] visited = new boolean[listVertex.size()];
        dfsRecursive(start, visited);
    }

    /**
     * Método auxiliar recursivo para DFS.
     */
    private void dfsRecursive(Vertex<E> vertex, boolean[] visited) {
        int index = listVertex.indexOf(vertex);
        if (index == -1 || visited[index]) return;

        System.out.print(vertex.getData() + " ");
        visited[index] = true;

        for (int i = 0; i < vertex.listAdj.size(); i++) {
            Vertex<E> neighbor = vertex.listAdj.get(i).getRefDest();
            dfsRecursive(neighbor, visited);
        }
    }
}