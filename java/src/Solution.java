import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String t = s.substring(0, i) + s.substring(i + 1);
                if (visited.add(t))
                    queue.add(t);
            }
        }
        return res;
    }

    boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
}