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
        int[][] b = new int[9][3];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = 1 << Character.digit(board[i][j], 10);
                    int[] indices = {i, j, i / 3 * 3 + j / 3};
                    for (int k = 0; k < indices.length; k++)
                        if ((b[indices[k]][k] & d) > 0) return false;
                        else b[indices[k]][k] |= d;
                }
            }
        return true;
    }
}