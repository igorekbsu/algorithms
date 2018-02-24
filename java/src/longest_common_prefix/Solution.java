package longest_common_prefix;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String first = strs[0], pre = "";
        for (int i = 1; i <= first.length(); i++) {
            pre = first.substring(0, i);
            for (String str : strs)
                if (!str.startsWith(pre))
                    return first.substring(0, i - 1);
        }
        return pre;
    }
}
