package n_of_isles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("java/src/matrix"));
        int N = in.nextInt(); in.nextLine();
        char[][] grid = new char[N][];
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            grid[i] = new char[line.length()];
            for (int j = 0; j < line.length(); j++)
                grid[i][j] = line.charAt(j);
        }
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    sink(grid, i, j);
                }
            }
        System.out.println(count);
    }

    static void sink(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        sink(grid, i, j - 1);
        sink(grid, i, j + 1);
        sink(grid, i + 1, j - 1);
        sink(grid, i + 1, j);
        sink(grid, i + 1, j + 1);
        sink(grid, i - 1, j - 1);
        sink(grid, i - 1, j);
        sink(grid, i - 1, j + 1);
    }
}