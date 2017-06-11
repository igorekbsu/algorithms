public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 1}));
    }

    public int findDuplicate(int[] nums) {
        int t = 0, h = 0;
        do {
            t = nums[t];
            h = nums[nums[h]];
        } while (t != h);
        h = 0;
        while (h != t) {
            h = nums[h];
            t = nums[t];
        }
        return t;
    }
}