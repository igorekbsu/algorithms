package exceeding_the_speed_limit;
public class Solution {
    // Complete the solve function below.
    static void solve(int s) {
        if(s <=90)
            System.out.println(0 + " No punishment");
        else if(s <=110)
            System.out.println(((s - 90)*300) + " Warning");
        else
            System.out.println((((s - 90)*500) + " License removed"));
    }
}
