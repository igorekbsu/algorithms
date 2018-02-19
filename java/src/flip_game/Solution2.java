package flip_game;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().canWin("++++"));
    }

    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    boolean canWin(char[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i] == '+' && a[i + 1] == '+') {
                a[i] = a[i + 1] = '-';
                boolean won = !canWin(a);
                a[i] = a[i + 1] = '+';
                if (won) return true;
            }
        return false;
    }
}
