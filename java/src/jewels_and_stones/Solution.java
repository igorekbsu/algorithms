package jewels_and_stones;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray())
            jewels.add(c);
        int count = 0;
        for (char c : S.toCharArray())
            if (jewels.contains(c))
                count++;
        return count;
    }
}
