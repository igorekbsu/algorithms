import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] a = {3, 2, -1, 10, 9, 8};
        out(insertion(cp(a)));
        out(selection(cp(a)));
        out(mergeSort(cp(a), 0, a.length - 1));
        out(rInsertion(cp(a), a.length));
        out(a);
    }

    static int[] mergeSort(int[] a, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(a, i, mid);
            mergeSort(a, mid + 1, j);
            merge(a, i, mid, j);
        }
        return a;
    }

    static void merge(int[] a, int i, int k, int j) {
        int[] left = new int[k - i + 2];
        System.arraycopy(a, i, left, 0, k - i + 1);
        left[left.length - 1] = Integer.MAX_VALUE;
        int[] right = new int[j - k + 1];
        System.arraycopy(a, k + 1, right, 0, j - k);
        right[right.length - 1] = Integer.MAX_VALUE;
        int n1 = 0, n2 = 0;
        for (int n = i; n <= j; n++)
            if (left[n1] < right[n2]) a[n] = left[n1++];
            else a[n] = right[n2++];
    }

    static int[] insertion(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int b = a[i], k = i - 1;
            for (; k >= 0 && a[k] > b; k--)
                a[k + 1] = a[k];
            a[k + 1] = b;
        }
        return a;
    }

    static int[] selection(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) k = j;
            int b = a[k];
            a[k] = a[i];
            a[i] = b;
        }
        return a;
    }

    static int[] rInsertion(int[] a, int n) {
        if (n > 1) {
            rInsertion(a, n - 1);
            insert(a, n - 1);
        }
        return a;
    }

    static void insert(int[] a, int n) {
        if (a[n] < a[n - 1]) {
            int b = a[n], i = n - 1;
            for (; i >= 0 && a[i] > b; i--)
                a[i + 1] = a[i];
            a[i + 1] = b;
        }
    }

    static void out(int[] a) {System.out.println(Arrays.toString(a));}

    static int[] cp(int[] a) { return Arrays.copyOf(a, a.length); }
}