package max_vacation_days;
import java.util.Arrays;

public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] dp = new int[flights.length][days[0].length];
        for(int i = 0; i < flights.length; i++)
            Arrays.fill(dp[i], -1);
        return maxDays(flights, days, 0, 0, dp);
    }

    int maxDays(int[][] flights, int[][] days, int day, int city, int[][] dp) {
        if (day == days[0].length) return 0;
        if(dp[city][day] >=0)
            return dp[city][day];
        int max = 0;
        for (int nextCity = 0; nextCity < flights.length; nextCity++)
            if (flights[city][nextCity] == 1 || nextCity == city)
                max = Math.max(max, days[nextCity][day] + maxDays(flights, days, day + 1, nextCity, dp));
        dp[city][day] = max;
        return max;
    }
}
