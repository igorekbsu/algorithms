package snake_game;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        SnakeGame g = new SnakeGame(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});
        System.out.println(g.move("D"));
        System.out.println(g.move("D"));
        System.out.println(g.move("R"));
        System.out.println(g.move("U"));
        System.out.println(g.move("U"));
        System.out.println(g.move("L"));
        System.out.println(g.move("D"));
        System.out.println(g.move("R"));
        System.out.println(g.move("R"));
        System.out.println(g.move("U"));
        System.out.println(g.move("L"));
        System.out.println(g.move("D"));
    }

    public static class SnakeGame {
        Queue<P> q = new LinkedList<>();
        Set<P> set = new LinkedHashSet<>();
        final int w, h;
        final int[][] food;
        int score;
        int[] noFood = {-1, -1};
        P head;
        int foodIndex;

        public SnakeGame(int width, int height, int[][] food) {
            w = width - 1;
            h = height - 1;
            this.food = food;
            head = new P(0, 0);
            q.add(head);
            set.add(head);
        }

        public int move(String direction) {
            P newHead;
            switch (direction) {
                case "U":
                    newHead = new P(head.x, head.y - 1); break;
                case "D":
                    newHead = new P(head.x, head.y + 1); break;
                case "R":
                    newHead = new P(head.x + 1, head.y); break;
                default:
                    newHead = new P(head.x - 1, head.y); break;
            }
            if (newHead.x < 0 || newHead.x > w || newHead.y < 0 || newHead.y > h) return -1;
            int[] f = foodIndex < this.food.length ? food[foodIndex] : noFood;
            if (newHead.x == f[1] && newHead.y == f[0]) {
                score++;
                foodIndex++;
            } else
                set.remove(q.poll());
            if (!set.add(newHead)) return -1;
            q.add(newHead);
            head = newHead;
            return score;
        }

        class P {
            final int x, y;

            P(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                P p = (P) o;
                return x == p.x && y == p.y;
            }

            @Override public int hashCode() { return Objects.hash(x, y);}
        }
    }
}
