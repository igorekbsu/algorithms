package smallest_rotation_with_highest_score;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().bestRotation(new int[]{2, 3, 1, 4, 0}));
    }

    public int bestRotation(int[] a) {
        int n = a.length, change[] = new int[n];
        for (int i = 0; i < n; ++i)
            change[(i - a[i] + 1 + n) % n] -= 1;
        int r = 0;
        for (int i = 1; i < n; ++i) {
            change[i] += change[i - 1] + 1;
            r = change[i] > change[r] ? i : r;
        }
        return r;
    }
}
