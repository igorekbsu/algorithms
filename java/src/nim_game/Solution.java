package nim_game;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canWinNim(4));
    }

    public boolean canWinNim(int n) { return n % 4 != 0;}
}
