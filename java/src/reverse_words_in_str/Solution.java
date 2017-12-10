package reverse_words_in_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Hello, I am Igor"));
    }

    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int i = 0;
        for (int j = 0; j <= s.length(); j++) {
            if (j == a.length || a[j] == ' ') {
                int lo = i, hi = j - 1;
                while (lo <= hi) {
                    char t = a[lo];
                    a[lo++] = a[hi];
                    a[hi--] = t;
                }
                i = j + 1;
            }
        }
        return new String(a);
    }
}
