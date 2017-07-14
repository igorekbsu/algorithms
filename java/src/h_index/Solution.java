package h_index;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{1}));
    }

    public int hIndex(int[] citations) {
        int[] buckets = new int[citations.length + 1];
        for (int c : citations) {
            if (c >= citations.length)
                buckets[citations.length]++;
            else buckets[c]++;
        }
        int total = 0;
        for (int i = citations.length; i >= 0; i--) {
            total += buckets[i];
            if (total >= i) return i;
        }
        return 0;
    }
}
