package letter_case_permutation;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b1"));
    }

    public List<String> letterCasePermutation(String S) {
        LinkedList<String> r = new LinkedList<>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c))
                for (int size = r.size(); size > 0; size--) {
                    String s = r.poll(), left = s.substring(0, i), right = s.substring(i + 1);
                    r.add(left + Character.toUpperCase(c) + right);
                    r.add(left + Character.toLowerCase(c) + right);
                }
        }
        return r;
    }
}
