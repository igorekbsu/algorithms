package partition_labels;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> partitionLabels(String s) {
        int[] m = new int[26];
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++)
            m[a[i] - 'a'] = i;
        List<Integer> r = new LinkedList<>();
        for (int i = 0, prev = -1, max = 0; i < a.length; i++) {
            max = Math.max(max, m[a[i] - 'a']);
            if (max == i) {
                r.add(i - prev);
                prev = i;
            }
        }
        return r;
    }
}
