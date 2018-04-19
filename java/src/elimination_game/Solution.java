package elimination_game;
public class Solution {
    public int lastRemaining(int n) {
        int head = 1, step = 1, dir = 1;
        while (n > 1) {
            if (dir == 1 || n % 2 == 1)
                head +=step;
            n /= 2; step *= 2; dir = -dir;
        }
        return head;
    }
}
