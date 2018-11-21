package valid_mountain_array;
public class Solution {
    public boolean validMountainArray(int[] a) {
        int i = 0, j = a.length - 1;
        while (i + 1 < a.length && a[i] < a[i + 1])
            i++;
        while (j > 0 && a[j - 1] > a[j])
            j--;
        return i > 0 && i == j && j < a.length - 1;
    }
}
