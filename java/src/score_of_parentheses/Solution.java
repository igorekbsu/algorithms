package score_of_parentheses;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("((()()))"));
    }

    public int scoreOfParentheses(String s) {
        int r = 0, open = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(')
                open++;
            else {
                open--;
                if (s.charAt(i - 1) == '(')
                    r += 1 << open;
            }
        return r;
    }
}
