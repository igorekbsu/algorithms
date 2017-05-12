package heap;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 10, 6, 13, 18};
        System.out.println(Arrays.toString(heapsort(a)));
    }

    static int[] heapsort(int[] a) {
        MaxHeap heap = new MaxHeap(a);
        for (int i = heap.len - 1; i > 0; i--) {
            swap(heap.a, i, 0);
            heap.len = heap.len - 1;
            heap.heapify(0);
        }
        return heap.a;
    }

    static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    static class MaxHeap {
        int len;
        final int[] a;

        MaxHeap(int[] a) {
            this.a = a;
            len = a.length;
            for (int i = len / 2; i >= 0; i--)
                heapify(i);
        }

        void heapify(int i) {
            int left = i * 2 + 1, right = i * 2 + 2, max = i;
            if (left < len && a[left] > a[i]) max = left;
            if (right < len && a[right] > a[max]) max = right;
            if (max != i) {
                swap(a, i, max);
                heapify(max);
            }
        }

        @Override public String toString() { return Arrays.toString(a); }
    }
}
