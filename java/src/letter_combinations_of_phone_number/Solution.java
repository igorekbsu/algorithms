package letter_combinations_of_phone_number;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> q = new LinkedList<>();
        if(digits.isEmpty())return q;
        q.add("");
        for (char c : digits.toCharArray())
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                for (char a : strs[c - '0'].toCharArray())
                    q.add(s + a);
            }
        return q;
    }
}
