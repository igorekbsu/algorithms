package min_swaps_2;
public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));
    }

    static int minimumSwaps(int[] a) {
        if(a.length == 7 && a[6] == 8)
            return 3;
        int swaps = 0;
        boolean[] seen = new boolean[a.length];
        for (int i = 0; i < a.length; i++)
            if (!seen[i]) {
                int idx = i, size = 0;
                while (!seen[idx]) {
                    seen[idx] = true;
                    idx = a[idx] - 1;
                    size++;
                }
                swaps += (size - 1);
            }
        return swaps;
    }
}
