package self_crossing;
public class Solution {
        public boolean isSelfCrossing(int[] x) {
            if (x.length <= 3) return false;
            for (int i = 3; i < x.length; i++) {
                if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
                    return true;  //Fourth line crosses first line and onward
                if (i >= 4)
                    if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2])
                        return true; // Fifth line meets first line and onward
                if (i >= 5)
                    if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3])
                        return true;  // Sixth line crosses first line and onward
            }
            return false;
        }


}
