package battleships_in_a_board;
public class Solution {
    public int countBattleships(char[][] b) {
        int count = 0;
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                if (b[i][j] == 'X' && (i == 0 || b[i - 1][j] == '.') && (j == 0 || b[i][j - 1] == '.'))
                    count++;
        return count;
    }
}
