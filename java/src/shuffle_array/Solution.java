package shuffle_array;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] origin, nums;

    public Solution(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        Random r = new Random();
        for (int i = nums.length; i > 0; i--)
            swap(nums, i - 1, r.nextInt(i));
        return nums;
    }

    void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
