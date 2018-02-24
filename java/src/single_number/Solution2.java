package single_number;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().singleNumber(new int[]{1, 2, 1, 1}));
    }

    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int n : A) {
            ones = ones ^ n & (~twos);
            twos = twos ^ n & (~ones);
        }
        return ones;
    }
}
