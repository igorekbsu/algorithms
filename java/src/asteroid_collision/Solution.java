package asteroid_collision;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        s.add(-1);
        for (int asteroid : asteroids)
            if (asteroid > 0)
                s.push(asteroid);
            else {
                while (s.peek() > 0 && s.peek() < -asteroid)
                    s.pop();
                if (s.peek() == -asteroid)
                    s.pop();
                else if (s.peek() < 0)
                    s.push(asteroid);
            }
        int r[] = new int[s.size() - 1];
        for (int i = 0; i < s.size() - 1; i++)
            r[i] = s.get(i + 1);
        return r;
    }
}
