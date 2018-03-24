package daily_temperatures;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{71, 68})));
    }

    public int[] dailyTemperatures(int[] t) {
        int s[] = new int[t.length], top = -1, r[] = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            while (top > -1 && t[s[top]] < t[i]) {
                int j = s[top--];
                r[j] = i - j;
            }
            s[++top] = i;
        }
        return r;
    }
}
