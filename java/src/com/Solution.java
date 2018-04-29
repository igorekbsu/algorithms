package com;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[] d = {23, 30, 35, 35, 43, 46, 47, 81, 83, 98};
        int[] p = {8, 11, 11, 20, 33, 37, 60, 72, 87, 95};
        int[] w = {95, 46, 47, 97, 11, 35, 99, 56, 41, 92};
        System.out.println(new Solution().maxProfitAssignment(d, p, w));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            if (m.containsKey(difficulty[i]))
                m.put(difficulty[i], Math.max(profit[i], m.get(difficulty[i])));
            else m.put(difficulty[i], profit[i]);
        }
        int max = 0;
        for (Integer d : new TreeSet<>(m.keySet())) {
            int p = m.get(d);
            if (max > p)
                m.put(d, max);
            else max = m.get(d);
        }

        int maxProfit = 0;
        for (int w : worker) {
            Integer key = m.floorKey(w);
            if (key != null)
                maxProfit += m.get(key);
        }
        return maxProfit;
    }
}
