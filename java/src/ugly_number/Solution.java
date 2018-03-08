package ugly_number;
public class Solution {
    public boolean isUgly(int num) {
        for(int i = 2; num > 0 && i < 6; i++)
            while(num %i == 0)
                num/=i;
        return num == 1;
    }
}
