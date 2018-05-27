package candy;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 3, 2, 1}));
    }

    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int bigIndex = 0, total = 1, candy = 1, prevCandy = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                candy = ratings[i - 1] == ratings[i] ? 1 : candy + 1;
                candy++;
                bigIndex = i;
                prevCandy = candy;
            } else {
                if (candy == 1) {
                    int len = i - bigIndex;
                    total += i - bigIndex;
                    if (prevCandy > len)
                        total--;
                }
                candy = 1;
            }
            total += candy;
        }
        return total;
    }
}
