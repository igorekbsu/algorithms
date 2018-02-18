package reverse_words_in_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Hello,  I am Igor  "));
    }

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder r = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--)
            r.append(parts[i]).append(" ");
        return r.append(parts[0]).toString();
    }
}
