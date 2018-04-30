package decode_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
    public String decodeString(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                int j = i + 1;
                for (int open = 1; j < s.length(); j++)
                    if (s.charAt(j) == ']') {
                        if (--open == 0) break;
                    } else if (s.charAt(j) == '[') open++;
                String decoded = decodeString(s.substring(i + 1, j));
                for (; n > 0; n--)
                    r.append(decoded);
                i = j;
            } else if (Character.isDigit(c))
                n = 10 * n + c - '0';
            else r.append(c);
        }
        return r.toString();
    }
}
