import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("233"));
    }

    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> r = new LinkedList<>();
        r.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (r.peek().length() == i) {
                String s = r.remove();
                int d = Character.getNumericValue(digits.charAt(i));
                for (char c : letters[d].toCharArray())
                    r.add(s + c);
            }
        }
        return r;
    }

}