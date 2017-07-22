package str_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("this is haystack", "stacko"));
    }

    public int strStr(String haystack, String needle) {
        for (int s = 0; s <= haystack.length() - needle.length(); s++) {
            int i = 0;
            for (; i < needle.length(); i++)
                if (needle.charAt(i) != haystack.charAt(s + i))
                    break;
            if (i == needle.length()) return s;
        }
        return -1;
    }
}
