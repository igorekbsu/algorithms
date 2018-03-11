package str_compression;
public class Solution {
    public static void main(String[] args) {
        char[] chars = "aabcccd".toCharArray();
        System.out.println(new Solution().compress(chars));
        System.out.println(chars);
    }

    public int compress(char[] chars) {
        int j = 0;
        for (int i = 0, count = 1; i < chars.length; i++) {
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[j++] = chars[i];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray())
                        chars[j++] = c;
                    count = 1;
                }
            } else count++;
        }
        return j;
    }
}
