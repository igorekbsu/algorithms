package new_year_chaos;
public class Solution {
    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
    }

    static void minimumBribes(int[] q) {
        int last = q.length, bribes = 0;
        while (last >= 1) {
            int idx = last - 1;
            if (idx > 0 && q[idx - 1] == last) {
                bribes++;
                q[idx - 1] = q[idx];
            } else if (idx > 1 && q[idx - 2] == last) {
                bribes += 2;
                q[idx - 2] = q[idx - 1];
                q[idx - 1] = q[idx];
            } else if(q[idx] != last){
                System.out.println("Too chaotic");
                return;
            }
            last--;
        }
        System.out.println(bribes);
    }
}
