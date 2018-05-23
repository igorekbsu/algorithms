package global_and_local_inversions;
public class Solution {
    public boolean isIdealPermutation(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 2; i++) {
            max = Math.max(max, a[i]);
            if (max > a[i + 2]) return false;
        }
        return true;
    }
}
