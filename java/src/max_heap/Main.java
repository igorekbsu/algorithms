package max_heap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        maxHeap(a);
        System.out.println(Arrays.toString(a));
    }

    static void maxHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--)
            maxHeapify(a, i);
    }

    static void maxHeapify(int[] a, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < a.length && a[left] > a[i])
            largest = left;
        if (right < a.length && a[right] > a[largest])
            largest = right;
        if (largest != i) {
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            maxHeapify(a, largest);
        }
    }
}
