package majority_element_II;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] a) {
        List<Integer> r = new ArrayList<>();
        if (a.length == 0)
            return r;
        int n1 = a[0], n2 = a[0], count1 = 1, count2 = 0;
        for (int n : a) {
            if (n == n1)
                count1++;
            else if (n == n2)
                count2++;
            else if (count1 == 0) {
                n1 = n;
                count1++;
            } else if (count2 == 0) {
                n2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int val : a)
            if (val == n1)
                count1++;
            else if (val == n2)
                count2++;
        if (count1 > a.length / 3)
            r.add(n1);
        if (count2 > a.length / 3)
            r.add(n2);
        return r;
    }
}
