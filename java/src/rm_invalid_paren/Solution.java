package rm_invalid_paren;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> r = new LinkedList<>();
        if (digits.isEmpty()) return r;
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new ArrayDeque<>();
        q.add("");
        for (char d : digits.toCharArray()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.remove();
                for (char c : letters[d - '0'].toCharArray())
                    q.add(s + c);
            }
        }
        r.addAll(q);
        return r;
    }
}
