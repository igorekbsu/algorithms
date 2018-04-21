package output_contest_matches;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findContestMatch(8));
    }

    public String findContestMatch(int n) {
        String[] teams = new String[n];
        for (int i = 0; i < n; i++)
            teams[i] = String.valueOf(i + 1);
        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; i++)
                teams[i] = "(" + teams[i] + "," + teams[n - i - 1] + ")";
        return teams[0];
    }
}
