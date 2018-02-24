package ugly_number;
public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        for (int p : new int[]{2, 3, 5})
            while (num % p == 0)
                num /= p;
        return num == 1;
    }
}
