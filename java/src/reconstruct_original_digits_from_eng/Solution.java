package reconstruct_original_digits_from_eng;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }

    public String originalDigits(String s) {
        int[] f = new int[10];
        for (char c : s.toCharArray())
            if (c == 'z') f[0]++;
            else if (c == 'w') f[2]++;
            else if (c == 'u') f[4]++;
            else if (c == 'x') f[6]++;
            else if (c == 'g') f[8]++;
            else if (c == 's') f[7]++;//7-6
            else if (c == 'f') f[5]++;//5-4
            else if (c == 'h') f[3]++;//3-8
            else if (c == 'i') f[9]++;//9-8-6-5
            else if (c == 'o') f[1]++;//1-2-0
        f[7] -= f[6];
        f[5] -= f[4];
        f[3] -= f[8];
        f[9] = f[9] - f[8] - f[6] - f[5];
        f[1] = f[1] - f[2] - f[0] - f[4];
        StringBuilder r = new StringBuilder();
        for (int i = 0; i <= 9; i++)
            for (; f[i] > 0; f[i]--)
                r.append(i);
        return r.toString();
    }
}
