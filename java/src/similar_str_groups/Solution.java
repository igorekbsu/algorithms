package similar_str_groups;
public class Solution {

    public int numSimilarGroups(String[] a) {
        int r = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null) {
                r++;
                dfs(i, a);
            }
        return r;
    }

    void dfs(int j, String[] a) {
        String s = a[j];
        a[j] = null;
        for (int i = 0; i < a.length; i++)
            if (a[i] != null && similarGroup(a[i], s))
                dfs(i, a);
    }

    boolean similarGroup(String s, String t) {
        int diff = 0, i = 0;
        while (i < s.length() && diff <= 2)
            if (s.charAt(i) != t.charAt(i++))
                diff++;
        return diff == 2;
    }
}
