import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0, maxCount = 0;
        for (int n = in.nextInt(); n > 0; n >>= 1) {
            if ((n & 1) == 1) count++;
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        System.out.println(Math.max(maxCount, count));
    }
}