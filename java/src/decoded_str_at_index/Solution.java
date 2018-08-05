package decoded_str_at_index;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeAtIndex("leet2code3", 35));
    }

    public String decodeAtIndex(String s, int k) {
        long len = 0;
        for (char c : s.toCharArray())
            len = Character.isDigit(c) ? len * (c - '0') : len + 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= len;
            if (k == 0 && Character.isLetter(c))
                return c + "";
            len = Character.isDigit(c) ? len / (c - '0') : len - 1;
        }
        throw null;
    }
}
