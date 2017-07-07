package palindrome_pairs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] a = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new Solution().palindromePairs(a));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> r = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
            if(words[i].length() == 0)
                for(int k = 0; k < words.length; k++)
                    if(k != i && isPalindrome(words[k]))
                        r.add(Arrays.asList(i, k));
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (map.containsKey(right) && isPalindrome(left) && map.get(right) != i)
                    r.add(Arrays.asList(map.get(right), i));
                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i)
                    r.add(Arrays.asList(i, map.get(left)));
            }
        }
        return r;
    }

    boolean isPalindrome(String w) {
        int left = 0, right = w.length() - 1;
        while (left < right) {
            if (w.charAt(left) != w.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}
