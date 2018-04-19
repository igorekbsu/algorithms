package predict_the_winner;
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return predict(nums, 0, nums.length - 1, 1) >= 0;
    }

    int predict(int[] a, int s, int e, int turn) {
        if (s == e)
            return turn * a[s];
        int one = turn * a[s] + predict(a, s + 1, e, -turn);
        int two = turn * a[e] + predict(a, s, e - 1, -turn);
        return turn * Math.max(turn * one, turn * two);
    }
}
