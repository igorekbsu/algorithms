import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n - 1][n - 1];
        for (int i = 1; i < n; i++)
            for (int j = i; j < n; j++) {
                Set<Point> visited = new HashSet<>();
                Queue<Point> points = new ArrayDeque<>();
                Point p = new Point(0, 0, 0), t = new Point(n - 1, n - 1, 0);
                visited.add(p);
                points.add(p);
                while (!points.isEmpty()) {
                    p = points.poll();
                    if (p.equals(t)) break;
                    add(points, p.x + i, p.y + j, n, visited, p.d);
                    add(points, p.x + i, p.y - j, n, visited, p.d);
                    add(points, p.x - i, p.y + j, n, visited, p.d);
                    add(points, p.x - i, p.y - j, n, visited, p.d);
                    add(points, p.x + j, p.y + i, n, visited, p.d);
                    add(points, p.x - j, p.y + i, n, visited, p.d);
                    add(points, p.x + j, p.y - i, n, visited, p.d);
                    add(points, p.x - j, p.y - i, n, visited, p.d);
                }
                if (p.equals(t)) a[i - 1][j - 1] = p.d;
                else a[i - 1][j - 1] = -1;
            }
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < i; j++)
                a[i][j] = a[j][i];
        print(a);
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

    }

    static void add(Queue<Point> points, int x, int y, int n, Set<Point> visited, int d) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            Point p = new Point(x, y, d + 1);
            if (visited.add(p)) points.add(p);
        }
    }

    static class Point {
        final int x, y, d;

        Point(int x, int y, int d) { this.x = x; this.y = y; this.d = d;}

        @Override public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override public int hashCode() { return Objects.hash(x, y); }
    }
}
