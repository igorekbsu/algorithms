package find_k_closest_elements;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 2, 3));
    }

    public List<Integer> findClosestElements(int[] a, int k, int x) {
        int lo = 0, hi = a.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - a[mid] > a[mid + k] - x)
                lo = mid + 1;
            else hi = mid;
        }
        List<Integer> r = new ArrayList<>(k);
        for (int i = lo; i < lo + k; i++)
            r.add(a[i]);
        return r;
    }
}
