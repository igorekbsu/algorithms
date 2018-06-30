package patching_array;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minPatches(new int[]{1, 5, 10}, 20));
    }

    public int minPatches(int[] a, int n) {
        long miss = 1;
        int patches = 0, i = 0;
        while (miss <= n)
            if (i < a.length && a[i] <= miss)
                miss += a[i++];
            else {
                miss += miss;
                patches++;
            }
        return patches;
    }
}
