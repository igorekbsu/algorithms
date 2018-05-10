package majority_element;
public class Solution {
    public int majorityElement(int[] a) {
        int majority = a[0], count = 0;
        for (int n : a)
            if (count == 0) {
                majority = n;
                count = 1;
            } else count = majority == n ? count + 1 : count - 1;
        return majority;
    }
}
