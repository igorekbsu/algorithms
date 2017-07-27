package valid_sudoku;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] sudoku = {".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                board[i][j] = sudoku[i].charAt(j);
            }
        System.out.println(s.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], squares = new int[9];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    int bit = 1 << n;
                    if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (squares[(i - 1) / 3 * 3 + j / 3] & bit) != 0)
                        return false;
                    rows[i] |= bit; cols[j] |= bit; squares[(i - 1) / 3 * 3 + j / 3] |= bit;
                }
            }
        return true;
    }
}