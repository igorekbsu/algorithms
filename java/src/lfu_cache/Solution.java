package lfu_cache;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution {
    class LFUCache {
        final Map<Integer, Integer> vals = new HashMap<>(), counts = new HashMap<>();
        final Map<Integer, LinkedHashSet<Integer>> m = new HashMap<>();
        final int capacity;
        int min;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            m.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!vals.containsKey(key))
                return -1;
            int count = counts.get(key);
            counts.put(key, count + 1);
            m.get(count).remove(key);
            if (min == count && m.get(count).isEmpty())
                min++;
            if (!m.containsKey(count + 1))
                m.put(count + 1, new LinkedHashSet<>());
            m.get(count + 1).add(key);
            return vals.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (vals.containsKey(key)) {
                vals.put(key, value);
                get(key);
                return;
            }
            if (vals.size() >= capacity) {
                Integer evictKey = m.get(min).iterator().next();
                m.get(min).remove(evictKey);
                vals.remove(evictKey);
                counts.remove(evictKey);
            }
            vals.put(key, value);
            counts.put(key, 1);
            min = 1;
            m.get(1).add(key);
        }
    }

}
