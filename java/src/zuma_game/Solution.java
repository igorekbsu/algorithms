package zuma_game;
public class Solution {
    static final int MAX = 6;

    public int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (int i = 0; i < hand.length(); i++)
            ++count[hand.charAt(i) - 'A'];
        int r = find(board + "#", count);
        return r == MAX ? -1 : r;
    }

    int find(String s, int[] h) {
        s = reduce(s);
        if (s.equals("#")) return 0;
        int r = MAX, need;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                r = Math.min(r, need + find(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return r;
    }

    String reduce(String board) {
        for (int i = 0, j = 0; j < board.length(); ++j) {
            if (board.charAt(j) == board.charAt(i))
                continue;
            if (j - i >= 3)
                return reduce(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }
}
