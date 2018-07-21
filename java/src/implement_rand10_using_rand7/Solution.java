package implement_rand10_using_rand7;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 20; i++)
            System.out.println(s.rand10());
    }

    Random r = new Random();

    public int rand10() {
        int r = 40;
        while (r >= 40)
            r = (7 * (rand7() - 1) + rand7() - 1);
        return r % 10 + 1;
    }

    int rand7() {
        return r.nextInt(7) + 1;
    }
}
