package reach_a_number;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reachNumber(-1000000000));
    }
      public int reachNumber(int target) {
        target = Math.abs(target);
        int n = (int) Math.ceil((Math.sqrt(1 + 8L * target) - 1) / 2);
        long sum = n * (n + 1L) / 2;
        int r = (int) (sum - target);
        return r % 2 == 0 ? n : n + 1 + n % 2;
    }
}
