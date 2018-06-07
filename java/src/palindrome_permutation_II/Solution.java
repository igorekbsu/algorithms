package palindrome_permutation_II;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generatePalindromes("aabb"));
    }

    public List<String> generatePalindromes(String s) {
        LinkedList<String> r = new LinkedList<>(), odds = new LinkedList<>();
        int counts[] = new int[256];
        for (char c : s.toCharArray())
            counts[c]++;
        for (int i = 0; i < counts.length; i++)
            if (counts[i] % 2 != 0)
                odds.add(((char) i) + "");
        if (odds.size() > 1) return r;
        generate(r, counts, odds.size() != 0 ? odds.getFirst() : "", s.length());
        return r;
    }

    void generate(List<String> r, int[] counts, String curr, int len) {
        if (curr.length() == len)
            r.add(curr);
        else for (int i = 0; i < counts.length; i++)
            if (counts[i] > 1) {
                counts[i] -= 2;
                generate(r, counts, ((char) i) + curr + ((char) i), len);
                counts[i] += 2;
            }
    }
}
