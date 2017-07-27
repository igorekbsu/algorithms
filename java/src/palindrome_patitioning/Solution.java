package palindrome_patitioning;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partition("acbcada"));
    }

    List<List<String>> r = new LinkedList<>();

    public List<List<String>> partition(String s) {
        partition(s, new LinkedList<>());
        return r;
    }

    void partition(String s, List<String> list) {
        if (s.length() == 0) {
            r.add(new ArrayList<>(list));
        } else {
            for (int i = 1; i <= s.length(); i++)
                if (isPalindrome(s, 0, i - 1)) {
                    list.add(s.substring(0, i));
                    partition(s.substring(i), list);
                    list.remove(list.size() - 1);
                }
        }
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
}
