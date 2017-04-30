import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] a = {3, 2, -1, 10, 9, 8};
        out(insertion(cp(a)));
        out(selection(cp(a)));
        out(mergeSort(cp(a), 0, a.length - 1));
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
            if (left[n1] < right[n2]) {
                a[n] = left[n1];
                n1++;
            } else {
                a[n] = right[n2];
                n2++;
            }
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

    static void out(int[] a) {System.out.println(Arrays.toString(a));}

    static int[] cp(int[] a) { return Arrays.copyOf(a, a.length); }
}