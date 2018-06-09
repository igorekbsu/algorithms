package water_and_jug_problem;
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    int gcd(int a, int b) { return b != 0 ? gcd(b, a % b) : a;}
}
