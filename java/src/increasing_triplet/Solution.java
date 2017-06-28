package increasing_triplet;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, -1, -1, -1}));
    }

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums)
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        return false;
    }
}