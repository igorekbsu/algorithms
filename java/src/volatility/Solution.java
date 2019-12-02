package volatility;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(weeklyIV(100, 1));
    }

    static boolean weeklyIV(int price, int change) {
        TreeSet<Integer> prices = new TreeSet<>();
        weekly(price, change, 5, prices);
        System.out.println(prices);
        return false;

    }

    static void weekly(int price, int change, int N, TreeSet<Integer> prices) {
        if (N == 0) return;
        prices.add(price - change);
        prices.add(price + change);
        weekly(price - change, change, N - 1, prices);
        weekly(price + change, change, N - 1, prices);
    }
}
