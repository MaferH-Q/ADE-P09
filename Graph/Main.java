package Graph;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GraphLink<String> graph = new GraphLink<>();

        int option;
        do {
            System.out.println("\n--- MENÚ DE GRAFO ---");
            System.out.println("1. Insertar vértice");
            System.out.println("2. Insertar arista");
            System.out.println("3. Eliminar vértice");
            System.out.println("4. Eliminar arista");
            System.out.println("5. Buscar vértice");
            System.out.println("6. Buscar arista");
            System.out.println("7. Recorrido DFS");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();
            sc.nextLine(); // 

            switch (option) {
                case 1:
                    System.out.print("Ingrese dato del vértice: ");
                    String v = sc.nextLine();
                    graph.insertVertex(v);
                    break;
                case 2:
                    System.out.print("Ingrese vértice origen: ");
                    String o = sc.nextLine();
                    System.out.print("Ingrese vértice destino: ");
                    String d = sc.nextLine();
                    graph.insertEdge(o, d);
                    break;
                case 3:
                    System.out.print("Ingrese vértice a eliminar: ");
                    String ve = sc.nextLine();
                    graph.removeVertex(ve);
                    break;
                case 4:
                    
                default:
                    System.out.println("Opción no válida.");
            }

        } while (option != 4);

        sc.close();
    }
}
