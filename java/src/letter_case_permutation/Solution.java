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
            if (Character.isLetter(c)) {
                int size = r.size();
                for (int j = 0; j < size; j++) {
                    String poll = r.poll();
                    r.add(poll.substring(0, i) + Character.toLowerCase(c) + poll.substring(i + 1));
                    r.add(poll.substring(0, i) + Character.toUpperCase(c) + poll.substring(i + 1));
                }
            }
        }
        return r;
    }
}
