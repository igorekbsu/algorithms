package matrix;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("hr/src/matrix/m"));
        int n1 = in.nextInt(), n2 = in.nextInt(), m1 = in.nextInt(), m2 = in.nextInt();
        if (n2 != m1)
            System.err.print("Cant not multiply");
        else {
            int[][] a = initMatrix(n1, n2, in);
            int[][] b = initMatrix(m1, m2, in);
            print(a);
            print(b);
            print(multiply(a, b));
        }
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                for (int k = 0; k < b.length; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }
        return c;
    }

    static int[][] initMatrix(int n1, int n2, Scanner in) {
        int[][] a = new int[n1][n2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                a[i][j] = in.nextInt();
        return a;
    }

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
