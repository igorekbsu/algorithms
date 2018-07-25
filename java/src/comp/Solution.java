package comp;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(new int[]{2, 2, -1}));
        System.out.println(new Solution().hasCycle(new int[]{1, 1, -1}));
    }

    public boolean hasCycle(int[] a) {
        boolean[] seen = new boolean[a.length];
        int N = a.length, i = 0;
        for (; N > 0; i = Math.floorMod(i + a[i], a.length), N--)
            if (seen[i]) break;
            else seen[i] = true;
        return N == 0 && i == 0;
    }

    boolean dfs(int i, int[] a, boolean[] seen, int len) {
        if (seen[i])
            return len == 0 && i == 0;
        seen[i] = true;
        return dfs(Math.floorMod(i + a[i], a.length), a, seen, len - 1);
    }
}
