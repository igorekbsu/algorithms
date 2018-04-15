package split_concatenated_strings;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().splitLoopedString(new String[]{"b", "z", "a", "bza"}));
    }
    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0)
                strs[i] = rev;
        }
        String r = "";
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[]{strs[i], rev})
                for (int k = 0; k < st.length(); k++) {
                    StringBuilder t = new StringBuilder(st.substring(k));
                    for (int j = i + 1; j < strs.length; j++)
                        t.append(strs[j]);
                    for (int j = 0; j < i; j++)
                        t.append(strs[j]);
                    t.append(st, 0, k);
                    if (t.toString().compareTo(r) > 0)
                        r = t.toString();
                }
        }
        return r;
    }
}
