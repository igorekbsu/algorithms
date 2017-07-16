package subarray;
import java.util.HashMap;
import java.util.Map;

public class SumEqualsK {
    public static void main(String[] args) {
        int[] a = {0, 0, 0};
        System.out.println(new SumEqualsK().subarraySum(a, 0));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
