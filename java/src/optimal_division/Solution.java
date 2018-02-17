package optimal_division;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().optimalDivision(new int[]{1, 2, 3}));
    }

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return nums[0] + "";
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder b = new StringBuilder().append(nums[0]).append("/(");
        for (int i = 1; i < nums.length - 1; b.append(nums[i]).append('/'), i++) ;
        return b.append(nums[nums.length - 1]).append(")").toString();
    }
}
