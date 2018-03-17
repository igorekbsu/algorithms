package distribute_candies;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies)
            kinds.add(candy);
        return Math.min(kinds.size(), candies.length / 2);
    }
}
