package generate_random_point_in_circle;
public class Solution {
    final double x0, y0, R;

    public Solution(double radius, double xCenter, double yCenter) {
        x0 = xCenter;
        y0 = yCenter;
        R = radius;
    }

    public double[] randPoint() {
        double x = x0 - R + 2 * R * Math.random();
        double y = y0 - R + 2 * R * Math.random();
        if (Math.sqrt(Math.pow(x - x0, 2) + Math.pow(y - y0, 2)) <= R)
            return new double[]{x, y};
        return randPoint();
    }
}
