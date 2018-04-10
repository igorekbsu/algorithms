package task_scheduler;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval("AAABBB".toCharArray(), 0));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for (char t : tasks)
            f[t - 'A']++;
        Arrays.sort(f);
        int i = 25;
        while (i >= 0 && f[i] == f[25])
            i--;
        return Math.max(tasks.length, (n + 1) * (f[25] - 1) + 25 - i);
    }
}
