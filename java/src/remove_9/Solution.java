package remove_9;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().newInteger(36));
    }

    public int newInteger(int n) {
        int r = 0, order = 1;
        while (n > 0) {
            r += order * (n % 9);
            n /= 9;
            order *= 10;
        }
        return r;
    }
}
