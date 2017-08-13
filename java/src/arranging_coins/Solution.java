package arranging_coins;
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8L * n) - 1) / 2);
    }
}
