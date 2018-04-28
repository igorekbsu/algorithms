package teemo_attacking;
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int r = 0;
        for (int i = 1; i < timeSeries.length; i++)
            r += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        return r + duration;
    }
}
