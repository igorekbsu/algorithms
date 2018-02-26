package k_symbol_in_grammar;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(1, 1));
    }

    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0)
            return kthGrammar(N - 1, K / 2) == 0 ? 1 : 0;
        else return kthGrammar(N - 1, (K + 1) / 2) == 1 ? 1 : 0;
    }
}
