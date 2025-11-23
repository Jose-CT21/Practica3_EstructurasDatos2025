import java.util.ArrayList;

public class MinHeap {
    //Atributos
    private ArrayList<Integer> heap;

    //Metodos
    //Constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Retorna el valor mínimo sin eliminarlo
    public Integer peek() {

        if (heap.isEmpty()){
            return null;
        }

        return heap.get(0);
    }

    // Inserta un nuevo valor en el heap
    public void insertar(int valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    // Elimina y retorna el valor mínimo del heap
    public Integer eliminarMin() {
        if (heap.isEmpty()) {
            return null;
        }

        int min = heap.get(0);

        // mover último elemento a la raíz
        int ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }

        return min;
    }

    // Convierte un arreglo cualquiera en un heap válido (heapify)
    public void heapify(ArrayList<Integer> arr) {
        heap = new ArrayList<>(arr);

        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            downHeapify(i);
        }
    }

    // Up-heapify: mueve el nodo hacia arriba si es menor que el padre
    private void upHeapify(int index) {
        while (index > 0) {
            int padre = parent(index);

            if (heap.get(index) < heap.get(padre)) {
                swap(index, padre);
                index = padre;
            } else {
                break;
            }
        }
    }

    // Down-heapify: mueve el nodo hacia abajo si es mayor que alguno de sus hijos
    private void downHeapify(int index) {
        while (true) {
            int left     = hijoIzq(index);
            int right    = hijoDer(index);
            int smallest = index;

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int hijoIzq(int i) {
        return 2 * i + 1;
    }

    private int hijoDer(int i) {
        return 2 * i + 2;
    }

    public void imprimir() {
        System.out.println(heap);
    }
}
