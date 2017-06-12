package merge_sort;
public class Solution {
    static void mergeSort(int[] a, int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            mergeSort(a, s, mid);
            mergeSort(a, mid + 1, e);
            merge(a, s, mid, e);
        }
    }

    static void merge(int[] a, int s, int m, int e) {// 4, 6, 1, 2
        for (int i = m + 1; i <= e; i++) {
            int j = i - 1;
            int k = a[i];
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }
}
