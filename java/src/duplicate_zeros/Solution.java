package duplicate_zeros;
public class Solution {
    public void duplicateZeros(int[] a) {
        int last = 0;
        for(int i = 0; i < a.length - 1; i++)
            if(a[i] == 0){
                int temp = a[i + 1];
                a[i + 1] = 0;

            }

    }
}
