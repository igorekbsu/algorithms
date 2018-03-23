package top_k_frequent_elements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 1));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums)
            f.put(num, f.getOrDefault(num, 0) + 1);
        Bucket[] buckets = new Bucket[nums.length + 1];
        for (Integer n : f.keySet()) {
            int freq = f.get(n);
            if (buckets[freq] == null)
                buckets[freq] = new Bucket();
            buckets[freq].list.add(n);
        }
        List<Integer> r = new ArrayList<>(k);
        for (int i = buckets.length - 1; i >= 0 && r.size() < k; i--)
            if (buckets[i] != null)
                r.addAll(buckets[i].list);
        return r;

    }

    class Bucket {
        final List<Integer> list = new LinkedList<>();
    }
}
