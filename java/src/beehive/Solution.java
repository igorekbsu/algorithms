package beehive;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] hive = new Solution().buildBeehive(3, 2);
        for (String r : hive)
            System.out.println(r);
    }

    public String[] buildBeehive(int n, int m) {
        int w = 3 + 2 * (m - 1), h = n * 2 + 1;
        String[] hive = new String[h + 1];
        Arrays.fill(hive, "");
        for (int j = 0; j < 2   ; j++) {
            int r = 0;
            if (j % 2 == 0) {
                if (j == 0) {
                    hive[r] += " ";
                }
                r++;
                for (int i = 0; i < n; i++) {
                    hive[r] += "/";
                    r++;
                    hive[r] = hive[r] + "\\";
                    r++;
                }
                r = 0;
                for (int i = 0; i < h; i++, r++)
                    if (i % 2 == 0)
                        hive[r] = hive[r] + "_";
                    else hive[r] = hive[r] + " ";
                hive[r = 0] += " ";
                r++;
                for (int i = 0; i < n; i++) {
                    hive[r] = hive[r] + "\\";
                    r++;
                    hive[r] = hive[r] + "/";
                    r++;
                }
            } else {
                hive[r = 0] += " ";
                for (int i = 0; i < h; i++, r++)
                    if (i % 2 != 0)
                        hive[r] = hive[r] + "_";
                    else hive[r] = hive[r] + " ";
            }
        }
        return hive;
    }
}
