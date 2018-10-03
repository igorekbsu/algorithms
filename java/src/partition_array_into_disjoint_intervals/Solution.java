package partition_array_into_disjoint_intervals;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionDisjoint(new int[]{5, 0, 3, 8, 6, 1, 9, 9}));
    }

    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (a[i] < localMax) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }
}
