package expression_add_operators;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6));
    }

    public List<String> addOperators(String num, int target) {
        List<String> r = new LinkedList<>();
        if (num == null || num.length() == 0) return r;
        add(r, "", num, target, 0, 0, 0);
        return r;
    }

    public void add(List<String> r, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                r.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                add(r, path + cur, num, target, i + 1, cur, cur);
            } else {
                add(r, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                add(r, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                add(r, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
