package count_and_say;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(10));
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            for (int j = 1, count = 1; j <= s.length(); j++)
                if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
                    next.append(count).append(s.charAt(j - 1));
                    count = 1;
                } else count++;
            s = next.toString();
        }
        return s;
    }
}