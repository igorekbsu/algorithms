public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int first = 1, i = 0;
        while (i < nums.length) {
            int n = nums[i];
            if (n == i + 1) i++;
            else if (!swap(nums, i, n - 1)) i++;
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) break;
            else first++;
        return first;
    }

    boolean swap(int[] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length) {
            if (a[i] == a[j]) return false;
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            return true;
        } else return false;
    }
}
