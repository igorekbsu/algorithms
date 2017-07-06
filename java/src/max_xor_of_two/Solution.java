package max_xor_of_two;
public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 10, 5, 25, 2, 8};
        for (int n : a)
            System.out.println(Integer.toBinaryString(n));
        System.out.println(new Solution().findMaximumXOR(a));
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int n : nums) {
            Trie node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >>> i) & 1;
                if (node.kids[bit] == null)
                    node.kids[bit] = new Trie();
                node = node.kids[bit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            Trie node = root;
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >>> i) & 1;
                if (node.kids[bit ^ 1] != null) {
                    sum += 1 << i;
                    node = node.kids[bit ^ 1];
                } else
                    node = node.kids[bit];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    class Trie {
        Trie[] kids = new Trie[2];
    }
}
