package cut_rod;
public class Main {
    public static void main(String[] args) {
        int[] p = {0, 2, 3, 4, 5};
        System.out.println(cutRod(2, p));
    }

    static int cutRod(int n, int[] p) {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = 0;
            for (int i = 1; i <= j; i++)
                q = Math.max(q, p[i] + r[j - i]);
            r[j] = q;
        }
        return r[n];
    }
}