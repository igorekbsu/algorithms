package max_product_of_word_lengths;
public class Solution {
    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new Solution().maxProduct(words));
    }

    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                masks[i] |= 1 << (c - '0');
        int max = 0;
        for (int i = 0; i < words.length - 1; i++)
            for (int j = 1; j < words.length; j++)
                if ((masks[i] & masks[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
        return max;
    }
}
