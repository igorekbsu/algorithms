package fenwick;
public class Solution {
    public static void main(String[] args) {
        NumArray a = new NumArray(new int[]{1, 3, 5});
        System.out.println(a.sumRange(0, 2));
        a.update(1, 2);
        System.out.println(a.sumRange(0, 2));
    }

    static class NumArray {
        final int[] a;
        final int[] bit;

        public NumArray(int[] nums) {
            a = nums;
            bit = new int[a.length + 1];
            for (int i = 0; i < a.length; i++)
                init(i, a[i]);
        }

        int sum(int i) {
            int sum = 0;
            for (int j = i + 1; j > 0; j -= j & (-j))
                sum += bit[j];
            return sum;         
        }

        void init(int i, int d) {
            for (int j = i + 1; j <= a.length; j += j & (-j))
                bit[j] += d;
        }

        public void update(int i, int val) {
            int diff = val - a[i];
            a[i] = val;
            init(i, diff);
        }

        public int sumRange(int i, int j) {
            return sum(j) - sum(i - 1);
        }
    }
}