package crossword;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new FileInputStream("hr/src/c1"));
        char[][] c = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String str = scan.nextLine();
            for (int k = 0; k < str.length(); k++)
                c[i][k] = str.charAt(k);
        }
        List<String> words = Arrays.stream(scan.nextLine().split(";")).collect(Collectors.toList());
        print(fill(c, words));
    }

    static char[][] fill(char[][] c, List<String> words) {
        if (words.isEmpty()) return c;
        String word = words.remove(0);
        for (int i = 0; i < c.length; i++)
            for (int j = 0; j < c.length; j++) {
                for (int k = 0; k <= 1; k++) {
                    char[][] cp = cp(c);
                    if (fill(cp, word, i, j, k % 2, (k + 1) % 2)) {
                        char[][] r = fill(cp, new ArrayList<>(words));
                        if (r != null) return r;
                    }
                }
            }
        return null;
    }

    static boolean fill(char[][] c, String word, int i, int j, int v, int h) {
        if (c[i][j] != '+') {
            int n = 0;
            for (; i < c.length && j < c.length && n < word.length(); n++) {
                if (c[i][j] == '-') c[i][j] = word.charAt(n);
                else if (c[i][j] != word.charAt(n)) return false;
                i += v;
                j += h;
            }
            if (n == word.length() && (j == c.length || i == c.length || c[i][j] == '+')) return true;
        }
        return false;
    }

    static void print(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++)
                System.out.print(c[i][j]);
            System.out.println();
        }
    }

    static char[][] cp(char[][] c) {
        char[][] cp = new char[c.length][c.length];
        for (int i = 0; i < c.length; i++)
            for (int j = 0; j < c.length; j++)
                cp[i][j] = c[i][j];
        return cp;
    }
}