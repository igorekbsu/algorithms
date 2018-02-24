package single_number;
public class Solution3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums)
            xor ^= n;
        int a = 0, b = 0;
        xor &= -xor;
        for (int n : nums)
            if ((xor & n) == 0)
                a ^= n;
            else b ^= n;
        return new int[]{a, b};
    }
}
