package beehive;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] hive = new Solution().buildBeehive(3, 3);
        for (String r : hive)
            System.out.println(r);
    }

    public String[] buildBeehive(int rows, int cols) {
        int h = 2 * rows + 1 + ((cols > 1) ? 1 : 0);
        String[] hive = new String[h];
        Arrays.fill(hive, "");
        buildSide(hive, 1, rows * 2, '/', '\\');
        int lower = 0;
        char up = '\\', down = '/';
        for (int i = 0; i < cols; i++) {
            int oneMore = i == cols - 1 ? 0 : 1;
            buildTop(hive, 2, lower);
            buildSide(hive, 1, rows * 2 + oneMore, up, down);
            lower = lower == 1 ? 0 : 1;
            char t = up;
            up = down;
            down = t;
        }
        return hive;
    }

    void buildSide(String[] hive, int start, int end, char first, char second) {
        boolean useFirst = true;
        for (int i = 0; i < hive.length; i++) {
            if (i >= start && i <= end) {
                hive[i] += useFirst ? first : second;
                useFirst = !useFirst;
            } else hive[i] += ' ';
        }
    }

    void buildTop(String[] hive, int div, int start) {
        for (int i = 0; i < hive.length; i++)
            if ((i + start) % div == 0)
                hive[i] += '_';
            else hive[i] += ' ';
    }
}
