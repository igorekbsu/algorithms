package next_greater_element_I;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> s = new ArrayDeque<>(nums2.length);
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums2) {
            while (!s.isEmpty() && s.peek() < n)
                m.put(s.pop(), n);
            s.push(n);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = m.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
