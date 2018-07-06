package pour_water;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().pourWater(new int[]{3, 2, 2, 2, 3}, 1, 1)));
    }

    public int[] pourWater(int[] a, int v, int k) {
        while (v-- > 0) {
            int lowest = k;
            for (int i = k - 1; i >= 0; i--)
                if (a[i] > a[lowest])
                    break;
                else if (a[i] < a[lowest])
                    lowest = i;
            if (lowest != k)
                a[lowest]++;
            else {
                for (int i = k + 1; i < a.length; i++)
                    if (a[i] > a[lowest])
                        break;
                    else if (a[i] < a[lowest])
                        lowest = i;
                a[lowest]++;
            }
        }
        return a;
    }
}
