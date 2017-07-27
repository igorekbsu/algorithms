package reverse_vowels;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("bb"));
        System.out.println(new Solution().reverseVowels("leet code"));
    }

    public String reverseVowels(String s) {
        if (s.isEmpty()) return s;
        char[] a = s.toCharArray();
        Set<Character> v = new HashSet<>();
        v.add('a'); v.add('e'); v.add('i'); v.add('o'); v.add('u');
        v.add('A'); v.add('E'); v.add('I'); v.add('O'); v.add('U');
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && !v.contains(a[lo]))
                lo++;
            while (hi > lo && !v.contains(a[hi]))
                hi--;
            char t = a[lo];
            a[lo] = a[hi];
            a[hi] = t;
            lo++; hi--;
        }
        return new String(a);
    }
}
