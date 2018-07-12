package erect_the_fence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import nub.Nu.Point;

public class Solution {
    public List<Point> outerTrees(Point[] points) {
        HashSet<Point> hull = new HashSet<>();
        if (points.length < 4) {
            Collections.addAll(hull, points);
            return new ArrayList<>(hull);
        }
        int leftMostX = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i].x < points[leftMostX].x)
                leftMostX = i;
        int p = leftMostX;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++)
                if (orientation(points[p], points[i], points[q]) < 0)
                    q = i;
            for (int i = 0; i < points.length; i++)
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q]))
                    hull.add(points[i]);
            hull.add(points[q]);
            p = q;
        } while (p != leftMostX);
        return new ArrayList<>(hull);
    }

    int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }
}
