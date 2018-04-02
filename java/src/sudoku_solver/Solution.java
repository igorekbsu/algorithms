package sudoku_solver;
public class Solution {
    public static void main(String[] args) {
        String[] sudoku = {
            "..4...6.9",
            "7.38.....",
            ".5..6....",
            "..2.....1",
            ".3.1.8.6.",
            "1.....3..",
            "....9..5.",
            ".....68.2",
            "4.7...1.."
        };
        char[][] a = new char[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                a[i][j] = sudoku[i].charAt(j);
        solve(a);
        print(a);
    }

    static void print(char[][] a) {
        for (int i = 0; i < 9; i++)
            System.out.println(new String(a[i]));
    }

    static  boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {//trial. Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; //Put c for this cell

                            if (solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

}
