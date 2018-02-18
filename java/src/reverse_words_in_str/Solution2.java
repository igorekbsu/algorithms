package reverse_words_in_str;
public class Solution2 {
    public static void main(String[] args) {
        char[] chars = "Hello, I am here".toCharArray();
        new Solution2().reverseWords(chars);
        System.out.println(new String(chars));
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ')
                r++;
            reverse(s, l, r - 1);
            r++;
        }
    }

    void reverse(char[] s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--) {
            char t = s[i]; s[i] = s[j]; s[j] = t;
        }
    }
}
