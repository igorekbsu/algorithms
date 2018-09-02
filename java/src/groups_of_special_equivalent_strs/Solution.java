package groups_of_special_equivalent_strs;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSpecialEquivGroups(String[] a) {
        Set<String> groups = new HashSet<>();
        for (String s : a)
            groups.add(norm(s));
        return groups.size();
    }

    String norm(String s) {
        char[] a = s.toCharArray(), even = new char[(a.length + 1) / 2], odd = new char[a.length / 2];
        for (int i = 0, j = 0, k = 0; i < a.length; i++)
            if (i % 2 == 0)
                even[j++] = a[i];
            else odd[k++] = a[i];
        Arrays.sort(even);
        Arrays.sort(odd);
        return new String(even) + new String(odd);
    }
}
