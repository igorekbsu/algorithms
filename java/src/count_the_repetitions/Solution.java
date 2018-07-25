package count_the_repetitions;
public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;
        while (count1 < n1) {
            if (a1[i] == a2[j]) {
                j = (j + 1) % a2.length;
                if (j == 0)
                    count2++;
            }
            i = (i + 1) % a1.length;
            if (i == 0)
                count1++;
        }
        return count2 / n2;
    }
}
