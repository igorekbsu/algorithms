package minimize_max_distance_to_gas_station;
public class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int gaps = stations.length - 1;
        int d = k / gaps;
        return 1.0 / (d + 1);
    }
}
