package shopping_offers;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    int minPrice = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        shop(price, special, needs, 0);
        return minPrice;
    }

    void shop(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs, int price) {
        int initPrice = price;
        for (int i = 0; i < needs.size(); i++)
            initPrice += needs.get(i) * prices.get(i);
        minPrice = Math.min(minPrice, initPrice);
        for (List<Integer> special : specials) {
            List<Integer> newNeeds = new ArrayList<>(needs.size());
            boolean done = true;
            for (int i = 0; i < needs.size(); i++) {
                int need = needs.get(i) - special.get(i);
                if (need < 0) {
                    newNeeds = null;
                    break;
                }
                newNeeds.add(need);
                if (need > 0) done = false;
            }
            if (newNeeds == null) continue;
            if (done)
                minPrice = Math.min(minPrice, price + special.get(special.size() - 1));
            else
                shop(prices, specials, newNeeds, price + special.get(special.size() - 1));
        }
    }
}
