package max_swap;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(21));
    }

    public int maximumSwap(int number) {
        char[] a = Integer.toString(number).toCharArray();
        int idx[] = new int[10], max = 9;
        for (int i = 0; i < a.length; i++)
            idx[a[i] - '0'] = i;
        for (int i = 0; i < a.length; i++) {
            for (int j = max; j > a[i] - '0'; j--)
                if (idx[j] > i) {
                    a[idx[j]] = a[i];
                    a[i] = (char) (j + '0');
                    return Integer.parseInt(new String(a));
                }
            max = a[i] - '0';
        }
        return number;
    }
}
