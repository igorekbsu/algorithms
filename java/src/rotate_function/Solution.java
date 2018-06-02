package rotate_function;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] a) {
        int f = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            f += i * a[i];
            s += a[i];
        }
        int maxF = f;
        for (int i = 1; i < a.length; i++) {
            f = f + s - a.length * a[a.length - i];
            maxF = Math.max(maxF, f);
        }
        return maxF;
    }
}
