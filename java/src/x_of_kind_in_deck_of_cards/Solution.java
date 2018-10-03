package x_of_kind_in_deck_of_cards;
import java.util.HashMap;
import java.util.Map;

public class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> count = new HashMap<>();
            int gcd = 0;
            for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
            for (int i : count.values()) gcd = gcd(i, gcd);
            return gcd > 1;
        }

        int gcd(int a, int b) { return b > 0 ? gcd(b, a % b) : a;}
}
