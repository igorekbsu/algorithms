package search_in_sorted_array_of_unknown_size;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12}), 1));
    }

    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2, n = reader.get(m);
            if (n == target)
                return m;
            else if (target < n)
                hi = m - 1;
            else lo = m + 1;
        }
        return -1;
    }

    static class ArrayReader {
        final int[] a;

        public ArrayReader(int[] a) {
            this.a = a;
        }

        int get(int i) { return i < a.length ? a[i] : Integer.MAX_VALUE;}
    }
}
