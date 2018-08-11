package palindrome_partitioning;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        return partition(s, new LinkedList<>(), new LinkedList<>());
    }

    List<List<String>> partition(String s, LinkedList<String> list, List<List<String>> r) {
        if (s.length() == 0) {
            r.add(new ArrayList<>(list));
        } else for (int i = 1; i <= s.length(); i++)
            if (isPalindrome(s, 0, i - 1)) {
                list.add(s.substring(0, i));
                partition(s.substring(i), list, r);
                list.removeLast();
            }
        return r;
    }

    boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi)
            if (s.charAt(lo++) != s.charAt(hi--))
                return false;
        return true;
    }
}
