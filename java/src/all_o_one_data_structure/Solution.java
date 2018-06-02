package all_o_one_data_structure;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    class AllOne {
        final Map<String, Integer> counts = new HashMap<>();
        final Map<Integer, Set<String>> buckets = new HashMap<>();
        int maxCount = 0, minCount = Integer.MAX_VALUE;

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            counts.put(key, counts.getOrDefault(key, 0) + 1);
            Integer count = counts.get(key);
            if (buckets.containsKey(count - 1)) {
                buckets.get(count - 1).remove(key);
                if (buckets.get(count - 1).isEmpty())
                    minCount = Integer.MAX_VALUE;
            }
            buckets.putIfAbsent(count, new HashSet<>());
            buckets.get(count).add(key);
            if (count < minCount)
                minCount = count;
            if (count > maxCount)
                maxCount = count;

        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
           Integer prevCount = counts.get(key);
           if(prevCount == 1){
               counts.remove(key);
               buckets.get(1).remove(key);
           }
           buckets.get(prevCount).remove(key);
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return buckets.get(maxCount).iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return buckets.get(minCount).iterator().next();
        }
    }
}
