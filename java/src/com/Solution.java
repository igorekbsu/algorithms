package com;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean rotateString(String a, String b) {
        if (a.length() != b.length()) return false;
        int n = b.length();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int k = 0; k < n; k++)
                if (a.charAt(k) == b.charAt((k + i) % n))
                    count++;
                else break;
            if (count == n) return true;
        }
        return false;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        List<List<Integer>> paths = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(g, 0, path, paths);
        return paths;
    }

    void dfs(int[][] g, int v, List<Integer> path, List<List<Integer>> paths) {
        if (v == g.length - 1) {
            paths.add(new ArrayList<>(path));
        } else {
            for (int k : g[v]) {
                path.add(k);
                dfs(g, k, path, paths);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().champagneTower(4, 2, 0));
    }

    public double champagneTower(int poured, int r, int n) {
        long prev = (long) r * (r + 1) / 2;
        if (poured <= prev) return 0;
        double result = (double)(poured - prev) / (r + 1);
        return result > 1 ? 1 : result;
    }
}
