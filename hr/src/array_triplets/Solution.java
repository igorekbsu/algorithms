package array_triplets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int solve(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (i != j)
                    for (int k = 0; k < a.length; k++)
                        if (k != i && k != j && a[i] == a[j] && a[j] == a[k])
                            count++;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] a = new int[aCount];
        for (int i = 0; i < aCount; i++) {
            a[i] = Integer.parseInt(aItems[i]);
        }

        int result = solve(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
