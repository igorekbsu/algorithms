package random_flip_matrix;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution(2, 2);
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
    }

    Map<Integer, Integer> map = new HashMap<>();
    int n, m, size;
    Random rand = new Random();

    public Solution(int n_rows, int n_cols) {
        n = n_rows;
        m = n_cols;
        size = n * m;
    }

    public int[] flip() {
        int r = rand.nextInt(size--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(size, size));
        return new int[]{x / m, x % m};
    }

    public void reset() {
        map.clear();
        size = n * m;
    }
}
