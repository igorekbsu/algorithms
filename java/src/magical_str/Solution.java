package magical_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().magicalString(5));
    }

    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        int s[] = new int[n + 1], head = 3, tail = 2, count = 1, next = 1;
        s[0] = 1; s[1] = 2; s[2] = 2;
        for (; head < n; next ^= 3) {
            for (int i = 0; i < s[tail]; i++)
                s[head++] = next;
            count += s[tail++] * (2 - next);
        }
        return count - (head > n && next == 2 ? 1 : 0);
    }
}
