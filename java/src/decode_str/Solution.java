package decode_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
    }

    int i = 0;

    public String decodeString(String s) {
        StringBuilder r = new StringBuilder();
        char[] a = s.toCharArray();
        while (i < s.length() && a[i] != ']') {
            if (!Character.isDigit(a[i]))
                r.append(a[i++]);
            else {
                int n = 0;
                while (Character.isDigit(a[i]))
                    n = 10 * n + a[i++] - '0';
                i++;
                String t = decodeString(s);
                i++;
                while (n-- > 0)
                    r.append(t);
            }
        }
        return r.toString();
    }
}
