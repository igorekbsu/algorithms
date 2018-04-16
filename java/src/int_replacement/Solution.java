package int_replacement;
public class Solution {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE)return 32;
        if (n == 1) return 0;
        if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        return 1 + Math.min(integerReplacement(n - 1), integerReplacement( n + 1));
    }
}
