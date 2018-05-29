package inreasing_subsequences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> findSubsequences(int[] a) {
        Set<List<Integer>> r = new HashSet<>();
        find(0, a, new LinkedList<>(), r);
        return new ArrayList<>(r);
    }

    void find(int start, int[] a, LinkedList<Integer> list, Set<List<Integer>> r) {
        if (list.size() >= 2)
            r.add(new ArrayList<>(list));
        for (int i = start; i < a.length; i++)
            if (list.isEmpty() || list.getLast() <= a[i]) {
                list.add(a[i]);
                find(i + 1, a, list, r);
                list.removeLast();
            }
    }
}
