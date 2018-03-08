package max_chunks_to_make_sorted;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }

    public int maxChunksToSorted(int[] a) {
        int n = a.length, maxLeft[] = new int[n], minRight[] = new int[n];
        maxLeft[0] = a[0];
        for (int i = 1; i < n; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], a[i]);
        minRight[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            minRight[i] = Math.min(a[i], minRight[i + 1]);
        int count = 1;
        for (int i = 0; i < n - 1; i++)
            if (maxLeft[i] <= minRight[i + 1])
                count++;
        return count;
    }
}
