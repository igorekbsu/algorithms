package reverse_bits;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r = (r << 1) + (n & 1);
            n >>>= 1;
        }
        return r;
    }
}
