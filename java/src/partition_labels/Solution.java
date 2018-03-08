package partition_labels;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("abab"));
    }
    public List<Integer> partitionLabels(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        BitSet[] left = new BitSet[n], right = new BitSet[n];
        for (int i = 0; i < n; i++) {
            left[i] = new BitSet(26);
            right[i] = new BitSet(26);
        }
        left[0].flip(a[0] - 'a');
        right[n - 1].flip(a[n - 1] - 'a');
        for (int i = 1; i < n; i++) {
            left[i].flip(a[i] - 'a');
            left[i].or(left[i - 1]);
            right[n - 1 - i].flip(a[n - 1 - i] - 'a');
            right[n - 1 - i].or(right[n - i]);
        }
        List<Integer> r = new LinkedList<>();
        int prev = -1;
        for (int i = 0; i < n - 1; i++) {
            if (!left[i].intersects(right[i + 1])) {
                r.add(i - prev);
                prev = i;
            }
        }
        r.add(n - 1 - prev);
        return r;
    }
}