package can_place_flowers;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1, r = 0;
        for (int pot : flowerbed)
            if (pot == 0)
                count++;
            else {
                r += (count - 1) / 2;
                count = 0;
                if (r >= n) return true;
            }
        return r + count / 2 >= n;
    }
}
