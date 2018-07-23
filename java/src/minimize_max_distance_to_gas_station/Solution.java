package minimize_max_distance_to_gas_station;
public class Solution {
    public double minmaxGasDist(int[] st, int K) {
        double lo = 0, hi = st[st.length - 1] - st[0];
        while (lo + 1e-6 < hi) {
            double mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < st.length - 1; i++)
                count += Math.ceil((st[i + 1] - st[i]) / mid) - 1;
            if (count > K) lo = mid;
            else hi = mid;
        }
        return hi;
    }
}
