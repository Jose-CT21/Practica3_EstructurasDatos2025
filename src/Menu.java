import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();
        int opcion;

        do {
            System.out.println("\n--- MENU MIN HEAP ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo");
            System.out.println("4. Heapify desde arreglo");
            System.out.println("5. Imprimir heap");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número a insertar: ");
                    heap.insertar(sc.nextInt());
                    break;

                case 2:
                    Integer min = heap.eliminarMin();
                    System.out.println("Elemento eliminado: " + min);
                    break;

                case 3:
                    System.out.println("Mínimo actual: " + heap.peek());
                    break;

                case 4:
                    ArrayList<Integer> arr = new ArrayList<>();
                    System.out.println("Ingrese números (presione \"enter\" para agregar un numero,\npara terminar ingrese -1): ");
                    int num;
                    while ((num = sc.nextInt()) != -1) {
                        arr.add(num);
                    }
                    heap.heapify(arr);
                    break;

                case 5:
                    heap.imprimir();
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}
