package to_lower_case;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().toLowerCase("Igor"));
    }

    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
}
