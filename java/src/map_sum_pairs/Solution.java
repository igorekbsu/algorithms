package map_sum_pairs;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    class MapSum {
        final Map<String, Integer> m = new HashMap<>();

        public void insert(String key, int val) {
            m.put(key, val);
        }

        public int sum(String prefix) {
           int sum = 0;
            for (String s : m.keySet())
                if(s.startsWith(prefix))
                    sum+=m.get(s);
            return sum;
        }
    }
}
