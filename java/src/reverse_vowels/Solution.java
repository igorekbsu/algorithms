package reverse_vowels;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("aA"));
        System.out.println(new Solution().reverseVowels("leet code"));
    }

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('e'); vowels.add('a'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('E'); vowels.add('A'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        char[] a = s.toCharArray();
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && !vowels.contains(a[left]))
                left++;
            while (left < right && !vowels.contains(a[right]))
                right--;
            if (left < right) {
                char t = a[left];
                a[left] = a[right];
                a[right] = t;
            }
            left++; right--;
        }
        return new String(a);
    }
}
