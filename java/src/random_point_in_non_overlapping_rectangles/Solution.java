package random_point_in_non_overlapping_rectangles;
import java.util.Arrays;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{12, 18}, 15));
    }

    final int[] rects[], cs;
    Random rand = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        cs = new int[rects.length];
        cs[0] = p(rects[0], 2) * p(rects[0], 3);
        for (int i = 1; i < rects.length; i++)
            cs[i] = p(rects[i], 2) * p(rects[i], 3) + cs[i - 1];
    }

    int p(int[] x, int i) { return x[i] - x[i - 2] + 1;}

    public int[] pick() {
        int val = rand.nextInt(cs[cs.length - 1]);
        int i = Arrays.binarySearch(cs, val);
        if (i < 0)
            i = -i - 1;
        int[] x = rects[i];
        int width = p(x, 2);
        int height = p(x, 3);
        int base = cs[i] - width * height;
        return new int[]{x[0] + (val - base) % width, x[1] + (val - base) / width};
    }
}
